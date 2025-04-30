package com.test.elibrary.service.impl;

import com.test.elibrary.dto.UserDTO;
import com.test.elibrary.dto.UserPasswordDTO;
import com.test.elibrary.entity.UserEntity;
import com.test.elibrary.repository.UserRepository;
import com.test.elibrary.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;


import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<UserEntity> getAllUsers() {
        return null;
    }

    @Override
    public UserEntity createUser(UserDTO userDTO) {
        return null;
    }

    @Override
    public UserEntity getUserById(Long id) {
        return null;
    }

    @Override
    public UserEntity changePassword(Long id, UserPasswordDTO userPasswordDto) {
        return null;
    }

    @Override
    public boolean existsByUsername(String username) {
        return false;
    }

    @Override
    public boolean existsByEmail(String email) {
        return false;
    }

    @Override
    public Optional<UserEntity> getUserByUsername(String username) {
        return Optional.empty();
    }
}
