package com.test.elibrary.service;

import com.test.elibrary.dto.UserDTO;
import com.test.elibrary.dto.UserPasswordDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserDTO> getAllUsers();

    UserDTO createUser(UserDTO userDTO);

    Optional<UserDTO> getUserById(Long id);

    UserDTO changePassword(Long id, UserPasswordDTO userPasswordDto);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    Optional<UserDTO> getUserByUsername(String username);
}
