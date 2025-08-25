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

    private UserResponseDTO mapToResponse(User user) {
        UserResponseDTO dto = new UserResponseDTO();
        dto.setUserId(user.getUserId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setRegisteredAt(user.getRegisteredAt());
        dto.setPan(user.getPan());
        dto.setAppAdmin(user.isAppAdmin());
        dto.setPoints(user.getPoints());
        return dto;
    }

    @Override
    public UserResponseDTO createUser(UserRequestDTO dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setRegisteredAt(dto.getRegisteredAt());
        user.setPan(dto.getPan());
        user.setAppAdmin(dto.isAppAdmin());
        user.setPoints(dto.getPoints());

        return mapToResponse(userRepository.save(user));
    }

    @Override
    public UserResponseDTO getUserById(Long id) {
        return userRepository.findById(id)
                .map(this::mapToResponse)
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll().stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    @Override
    public UserResponseDTO updateUser(Long id, UserRequestDTO dto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setRegisteredAt(dto.getRegisteredAt());
        user.setPan(dto.getPan());
        user.setAppAdmin(dto.isAppAdmin());
        user.setPoints(dto.getPoints());

        return mapToResponse(userRepository.save(user));
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
