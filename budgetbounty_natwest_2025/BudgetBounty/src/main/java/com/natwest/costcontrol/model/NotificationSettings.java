package com.natwest.costcontrol.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "notification_settings")
public class NotificationSettings {

    public enum NotificationFrequency {
        IMMEDIATE, DAILY, WEEKLY, MONTHLY
    }

    public enum NotificationChannel {
        EMAIL, SMS, PUSH
    }

    @Id
    @Column(name = "setting_id", length = 36)
    private String settingId;

    @Column(name = "user_id", length = 36, unique = true)
    private String userId;

    @Enumerated(EnumType.STRING)
    @Column(name = "notification_frequency", nullable = false)
    private NotificationFrequency notificationFrequency;

    @Enumerated(EnumType.STRING)
    @Column(name = "notification_channel", nullable = false)
    private NotificationChannel notificationChannel;

    // Constructors
    public NotificationSettings() {}

    public NotificationSettings(String settingId, String userId, 
                               NotificationFrequency notificationFrequency, 
                               NotificationChannel notificationChannel) {
        this.settingId = settingId;
        this.userId = userId;
        this.notificationFrequency = notificationFrequency;
        this.notificationChannel = notificationChannel;
    }

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