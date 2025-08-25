package com.natwest.costcontrol.dto;

import com.natwest.costcontrol.model.NotificationSettings.NotificationChannel;
import com.natwest.costcontrol.model.NotificationSettings.NotificationFrequency;

public class NotificationSettingsResponseDTO {
    private String settingId;
    private String userId;
    private NotificationFrequency notificationFrequency;
    private NotificationChannel notificationChannel;

    // Getters and Setters
    public String getSettingId() {
        return settingId;
    }

    public void setSettingId(String settingId) {
        this.settingId = settingId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public NotificationFrequency getNotificationFrequency() {
        return notificationFrequency;
    }

    public void setNotificationFrequency(NotificationFrequency notificationFrequency) {
        this.notificationFrequency = notificationFrequency;
    }

    public NotificationChannel getNotificationChannel() {
        return notificationChannel;
    }

    public void setNotificationChannel(NotificationChannel notificationChannel) {
        this.notificationChannel = notificationChannel;
    }
}