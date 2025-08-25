package com.natwest.costcontrol.service.impl;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.natwest.costcontrol.dto.NotificationSettingsRequestDTO;
import com.natwest.costcontrol.dto.NotificationSettingsResponseDTO;
import com.natwest.costcontrol.model.NotificationSettings;
import com.natwest.costcontrol.repository.NotificationSettingsRepository;
import com.natwest.costcontrol.service.NotificationSettingsService;

@Service
public class NotificationSettingsServiceImpl implements NotificationSettingsService {

    private final NotificationSettingsRepository notificationSettingsRepository;

    public NotificationSettingsServiceImpl(NotificationSettingsRepository notificationSettingsRepository) {
        this.notificationSettingsRepository = notificationSettingsRepository;
    }

    @Override
    public NotificationSettingsResponseDTO createNotificationSettings(NotificationSettingsRequestDTO requestDTO) {
        // Check if user already has settings
        Optional<NotificationSettings> existingSettings = notificationSettingsRepository.findByUserId(requestDTO.getUserId());
        if (existingSettings.isPresent()) {
            throw new RuntimeException("Notification settings already exist for user " + requestDTO.getUserId());
        }

        NotificationSettings settings = new NotificationSettings();
        settings.setSettingId(UUID.randomUUID().toString());
        settings.setUserId(requestDTO.getUserId());
        settings.setNotificationFrequency(requestDTO.getNotificationFrequency());
        settings.setNotificationChannel(requestDTO.getNotificationChannel());

        NotificationSettings saved = notificationSettingsRepository.save(settings);
        return mapToResponseDTO(saved);
    }

    @Override
    public NotificationSettingsResponseDTO getNotificationSettingsById(String id) {
        Optional<NotificationSettings> settingsOpt = notificationSettingsRepository.findById(id);
        return settingsOpt.map(this::mapToResponseDTO)
                .orElseThrow(() -> new RuntimeException("Notification settings not found with id " + id));
    }

    @Override
    public NotificationSettingsResponseDTO getNotificationSettingsByUserId(String userId) {
        Optional<NotificationSettings> settingsOpt = notificationSettingsRepository.findByUserId(userId);
        return settingsOpt.map(this::mapToResponseDTO)
                .orElseThrow(() -> new RuntimeException("Notification settings not found for user " + userId));
    }

    @Override
    public NotificationSettingsResponseDTO updateNotificationSettings(String id, NotificationSettingsRequestDTO requestDTO) {
        Optional<NotificationSettings> settingsOpt = notificationSettingsRepository.findById(id);
        if (settingsOpt.isPresent()) {
            NotificationSettings settings = settingsOpt.get();
            settings.setNotificationFrequency(requestDTO.getNotificationFrequency());
            settings.setNotificationChannel(requestDTO.getNotificationChannel());

            NotificationSettings updated = notificationSettingsRepository.save(settings);
            return mapToResponseDTO(updated);
        }
        throw new RuntimeException("Notification settings not found with id " + id);
    }

    @Override
    public void deleteNotificationSettings(String id) {
        if (!notificationSettingsRepository.existsById(id)) {
            throw new RuntimeException("Notification settings not found with id " + id);
        }
        notificationSettingsRepository.deleteById(id);
    }

    private NotificationSettingsResponseDTO mapToResponseDTO(NotificationSettings settings) {
        NotificationSettingsResponseDTO dto = new NotificationSettingsResponseDTO();
        dto.setSettingId(settings.getSettingId());
        dto.setUserId(settings.getUserId());
        dto.setNotificationFrequency(settings.getNotificationFrequency());
        dto.setNotificationChannel(settings.getNotificationChannel());
        return dto;
    }
}