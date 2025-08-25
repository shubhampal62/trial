package com.natwest.costcontrol.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.natwest.costcontrol.dto.NotificationSettingsRequestDTO;
import com.natwest.costcontrol.dto.NotificationSettingsResponseDTO;
import com.natwest.costcontrol.service.NotificationSettingsService;

@RestController
@RequestMapping("/api/notification-settings")
public class NotificationSettingsController {

    private final NotificationSettingsService notificationSettingsService;

    public NotificationSettingsController(NotificationSettingsService notificationSettingsService) {
        this.notificationSettingsService = notificationSettingsService;
    }

    @PostMapping
    public ResponseEntity<NotificationSettingsResponseDTO> createNotificationSettings(@RequestBody NotificationSettingsRequestDTO requestDTO) {
        return ResponseEntity.ok(notificationSettingsService.createNotificationSettings(requestDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotificationSettingsResponseDTO> getNotificationSettingsById(@PathVariable String id) {
        return ResponseEntity.ok(notificationSettingsService.getNotificationSettingsById(id));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<NotificationSettingsResponseDTO> getNotificationSettingsByUserId(@PathVariable String userId) {
        return ResponseEntity.ok(notificationSettingsService.getNotificationSettingsByUserId(userId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<NotificationSettingsResponseDTO> updateNotificationSettings(@PathVariable String id, @RequestBody NotificationSettingsRequestDTO requestDTO) {
        return ResponseEntity.ok(notificationSettingsService.updateNotificationSettings(id, requestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotificationSettings(@PathVariable String id) {
        notificationSettingsService.deleteNotificationSettings(id);
        return ResponseEntity.noContent().build();
    }
}