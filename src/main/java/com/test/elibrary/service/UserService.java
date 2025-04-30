package com.test.elibrary.service;

import com.test.elibrary.dto.UserDTO;
import com.test.elibrary.dto.UserPasswordDTO;
import com.test.elibrary.entity.UserEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public interface UserService {

    List<UserEntity> getAllUsers();
    UserEntity createUser(UserDTO userDTO);
    UserEntity getUserById(Long id);
    UserEntity changePassword(Long id, UserPasswordDTO userPasswordDto);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    Optional<UserEntity> getUserByUsername(String username);
}
