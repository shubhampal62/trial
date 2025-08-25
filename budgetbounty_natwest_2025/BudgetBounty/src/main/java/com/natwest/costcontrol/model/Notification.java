package com.natwest.costcontrol.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "notifications")
public class Notification {

    @Id
    @Column(name = "notification_id", length = 36)
    private String notificationId;

    @Column(name = "user_id", length = 36)
    private String userId;

    @Column(name = "budget_id", length = 36)
    private String budgetId;

    @Column(name = "notification_type", length = 50)
    private String notificationType;

    @Column(name = "message", length = 4000)
    private String message;

    @Column(name = "sent_at")
    private LocalDateTime sentAt;

    // Constructors
    public Notification() {}

    public Notification(String notificationId, String userId, String budgetId, 
                       String notificationType, String message, LocalDateTime sentAt) {
        this.notificationId = notificationId;
        this.userId = userId;
        this.budgetId = budgetId;
        this.notificationType = notificationType;
        this.message = message;
        this.sentAt = sentAt;
    }

    // Getters and Setters
    public String getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(String notificationId) {
        this.notificationId = notificationId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBudgetId() {
        return budgetId;
    }

    public void setBudgetId(String budgetId) {
        this.budgetId = budgetId;
    }

    public String getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(String notificationType) {
        this.notificationType = notificationType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }

    public void setSentAt(LocalDateTime sentAt) {
        this.sentAt = sentAt;
    }
}