package com.test.elibrary.service.impl;

import com.test.elibrary.dto.UserDTO;
import com.test.elibrary.dto.UserPasswordDTO;
import com.test.elibrary.entity.RoleEntity;
import com.test.elibrary.entity.UserEntity;
import com.test.elibrary.repository.RoleRepository;
import com.test.elibrary.repository.UserRepository;
import com.test.elibrary.service.UserService;
import com.test.elibrary.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        UserEntity newUserEntity = new UserEntity();
        newUserEntity.setUsername(userDTO.getUsername());
        newUserEntity.setId(userDTO.getId());
        newUserEntity.setEmail(userDTO.getEmail());
        newUserEntity.setPassword(userDTO.getPassword());

        Set<RoleEntity> roleEntities = userDTO.getRoles().stream()
                .map(roleName -> roleRepository.findByName(roleName)
                        .orElseThrow(() -> new RuntimeException("Role not found: " + roleName)))
                .collect(Collectors.toSet());

        newUserEntity.setRoles(roleEntities);
        UserEntity savedUser = userRepository.save(newUserEntity);
        return userMapper.toDto(savedUser);
    }

    @Override
    public Optional<UserDTO> getUserById(Long id) {
        return userRepository.findById(id).map(userMapper::toDto);
    }

    @Override
    public UserDTO changePassword(Long id, UserPasswordDTO userPasswordDto) {
        UserEntity userEntity = userRepository.findById(id).orElse(null);

        if (userEntity == null) {
            return null;
        } else {
            userEntity.setPassword(userPasswordDto.getPassword());
            UserEntity updatedUser = userRepository.save(userEntity);
            return userMapper.toDto(updatedUser);
        }
    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public Optional<UserDTO> getUserByUsername(String username) {
        return userRepository.findByUsername(username).map(userMapper::toDto);
    }
}
