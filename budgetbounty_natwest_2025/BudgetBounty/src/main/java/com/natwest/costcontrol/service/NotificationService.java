package com.natwest.costcontrol.service;

import java.util.List;

import com.natwest.costcontrol.dto.NotificationRequestDTO;
import com.natwest.costcontrol.dto.NotificationResponseDTO;

public interface NotificationService {
    NotificationResponseDTO createNotification(NotificationRequestDTO requestDTO);
    NotificationResponseDTO getNotificationById(String id);
    List<NotificationResponseDTO> getAllNotifications();
    List<NotificationResponseDTO> getNotificationsByUserId(String userId);
    List<NotificationResponseDTO> getNotificationsByBudgetId(String budgetId);
    NotificationResponseDTO updateNotification(String id, NotificationRequestDTO requestDTO);
    void deleteNotification(String id);
}