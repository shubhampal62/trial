package com.natwest.costcontrol.service.impl;

import com.natwest.costcontrol.dto.UserRequestDTO;
import com.natwest.costcontrol.dto.UserResponseDTO;
import com.natwest.costcontrol.model.User;
import com.natwest.costcontrol.repository.UserRepository;
import com.natwest.costcontrol.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        User user = new User();
        user.setUsername(userRequestDTO.getUsername());
        user.setEmail(userRequestDTO.getEmail());
        user.setFirstName(userRequestDTO.getFirstName());
        user.setLastName(userRequestDTO.getLastName());
        User saved = userRepository.save(user);

        return toDTO(saved);
    }

    @Override
    public UserResponseDTO getUserById(Long id) {
        return userRepository.findById(id)
                .map(this::toDTO)
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll()
                .stream().map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseDTO updateUser(Long id, UserRequestDTO dto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());

        return toDTO(userRepository.save(user));
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    private UserResponseDTO toDTO(User user) {
        UserResponseDTO dto = new UserResponseDTO();
        dto.setUserId(user.getUserId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        return dto;
    }
}
