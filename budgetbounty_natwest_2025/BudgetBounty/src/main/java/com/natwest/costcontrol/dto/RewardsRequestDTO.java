package com.natwest.costcontrol.dto;

import java.time.LocalDateTime;

public class RewardsRequestDTO {

    private String userId;
    private String goalId;
    private String activityId;
    private String budgetId;
    private int points;
    private LocalDateTime earnedAt;
    private String catalogItemId;
    private String reason;

    public RewardsRequestDTO() {}

    // Getters & Setters
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getGoalId() { return goalId; }
    public void setGoalId(String goalId) { this.goalId = goalId; }

    public String getActivityId() { return activityId; }
    public void setActivityId(String activityId) { this.activityId = activityId; }

    public String getBudgetId() { return budgetId; }
    public void setBudgetId(String budgetId) { this.budgetId = budgetId; }

    public int getPoints() { return points; }
    public void setPoints(int points) { this.points = points; }

    public LocalDateTime getEarnedAt() { return earnedAt; }
    public void setEarnedAt(LocalDateTime earnedAt) { this.earnedAt = earnedAt; }

    public String getCatalogItemId() { return catalogItemId; }
    public void setCatalogItemId(String catalogItemId) { this.catalogItemId = catalogItemId; }

    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }
}
