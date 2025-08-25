package com.natwest.costcontrol.service;

import com.natwest.costcontrol.dto.NotificationSettingsRequestDTO;
import com.natwest.costcontrol.dto.NotificationSettingsResponseDTO;

public interface NotificationSettingsService {
    NotificationSettingsResponseDTO createNotificationSettings(NotificationSettingsRequestDTO requestDTO);
    NotificationSettingsResponseDTO getNotificationSettingsById(String id);
    NotificationSettingsResponseDTO getNotificationSettingsByUserId(String userId);
    NotificationSettingsResponseDTO updateNotificationSettings(String id, NotificationSettingsRequestDTO requestDTO);
    void deleteNotificationSettings(String id);
}