package com.natwest.costcontrol.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.natwest.costcontrol.dto.NotificationRequestDTO;
import com.natwest.costcontrol.dto.NotificationResponseDTO;
import com.natwest.costcontrol.model.Notification;
import com.natwest.costcontrol.repository.NotificationRepository;
import com.natwest.costcontrol.service.NotificationService;

@Service
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationServiceImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public NotificationResponseDTO createNotification(NotificationRequestDTO requestDTO) {
        Notification notification = new Notification();
        notification.setNotificationId(UUID.randomUUID().toString());
        notification.setUserId(requestDTO.getUserId());
        notification.setBudgetId(requestDTO.getBudgetId());
        notification.setNotificationType(requestDTO.getNotificationType());
        notification.setMessage(requestDTO.getMessage());
        notification.setSentAt(requestDTO.getSentAt());

        Notification saved = notificationRepository.save(notification);
        return mapToResponseDTO(saved);
    }

    @Override
    public NotificationResponseDTO getNotificationById(String id) {
        Optional<Notification> notificationOpt = notificationRepository.findById(id);
        return notificationOpt.map(this::mapToResponseDTO)
                .orElseThrow(() -> new RuntimeException("Notification not found with id " + id));
    }

    @Override
    public List<NotificationResponseDTO> getAllNotifications() {
        return notificationRepository.findAll().stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<NotificationResponseDTO> getNotificationsByUserId(String userId) {
        return notificationRepository.findByUserId(userId).stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<NotificationResponseDTO> getNotificationsByBudgetId(String budgetId) {
        return notificationRepository.findByBudgetId(budgetId).stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public NotificationResponseDTO updateNotification(String id, NotificationRequestDTO requestDTO) {
        Optional<Notification> notificationOpt = notificationRepository.findById(id);
        if (notificationOpt.isPresent()) {
            Notification notification = notificationOpt.get();
            notification.setUserId(requestDTO.getUserId());
            notification.setBudgetId(requestDTO.getBudgetId());
            notification.setNotificationType(requestDTO.getNotificationType());
            notification.setMessage(requestDTO.getMessage());
            notification.setSentAt(requestDTO.getSentAt());

            Notification updated = notificationRepository.save(notification);
            return mapToResponseDTO(updated);
        }
        throw new RuntimeException("Notification not found with id " + id);
    }

    @Override
    public void deleteNotification(String id) {
        if (!notificationRepository.existsById(id)) {
            throw new RuntimeException("Notification not found with id " + id);
        }
        notificationRepository.deleteById(id);
    }

    private NotificationResponseDTO mapToResponseDTO(Notification notification) {
        NotificationResponseDTO dto = new NotificationResponseDTO();
        dto.setNotificationId(notification.getNotificationId());
        dto.setUserId(notification.getUserId());
        dto.setBudgetId(notification.getBudgetId());
        dto.setNotificationType(notification.getNotificationType());
        dto.setMessage(notification.getMessage());
        dto.setSentAt(notification.getSentAt());
        return dto;
    }
}