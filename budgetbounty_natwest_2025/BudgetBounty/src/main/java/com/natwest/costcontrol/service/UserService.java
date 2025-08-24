package com.natwest.costcontrol.service;

import com.natwest.costcontrol.dto.UserRequestDTO;
import com.natwest.costcontrol.dto.UserResponseDTO;

import java.util.List;

public interface UserService {
    UserResponseDTO createUser(UserRequestDTO userRequestDTO);
    UserResponseDTO getUserById(Long id);
    List<UserResponseDTO> getAllUsers();
    UserResponseDTO updateUser(Long id, UserRequestDTO userRequestDTO);
    void deleteUser(Long id);
}
