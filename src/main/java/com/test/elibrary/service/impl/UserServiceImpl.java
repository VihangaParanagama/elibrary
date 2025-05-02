package com.test.elibrary.service.impl;

import com.test.elibrary.dto.UserDTO;
import com.test.elibrary.dto.UserPasswordDTO;
import com.test.elibrary.entity.RoleEntity;
import com.test.elibrary.entity.UserEntity;
import com.test.elibrary.repository.RoleRepository;
import com.test.elibrary.repository.UserRepository;
import com.test.elibrary.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;


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

    @Override
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity createUser(UserDTO userDTO) {
        UserEntity newUserEntity  = new UserEntity();
        newUserEntity .setUsername(userDTO.getUsername());
        newUserEntity .setUserId(userDTO.getId());
        newUserEntity .setEmail(userDTO.getEmail());
        newUserEntity .setPassword(userDTO.getPassword());

        Set<RoleEntity> roleEntities = userDTO.getRoles().stream()
                .map(roleName -> roleRepository.findByName(roleName)
                        .orElseThrow(() -> new RuntimeException("Role not found: " + roleName)))
                .collect(Collectors.toSet());

        newUserEntity .setRoles(roleEntities);
        return userRepository.save(newUserEntity );
    }

    @Override
    public Optional<UserEntity> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public UserEntity changePassword(Long id, UserPasswordDTO userPasswordDto) {
        UserEntity userEntity = userRepository.findById(id).orElse(null);

        if(userEntity == null){
            return null;
        }else{
            return  userRepository.save(userEntity);
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
    public Optional<UserEntity> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
