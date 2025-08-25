package com.natwest.costcontrol.dto;

import java.time.LocalDateTime;

public class RewardsResponseDTO {

    private String rewardId;
    private String userId;
    private int points;
    private LocalDateTime earnedAt;
    private String reason;

    public RewardsResponseDTO() {}

    public RewardsResponseDTO(String rewardId, String userId, int points, LocalDateTime earnedAt, String reason) {
        this.rewardId = rewardId;
        this.userId = userId;
        this.points = points;
        this.earnedAt = earnedAt;
        this.reason = reason;
    }

    // Getters & Setters
    public String getRewardId() { return rewardId; }
    public void setRewardId(String rewardId) { this.rewardId = rewardId; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public int getPoints() { return points; }
    public void setPoints(int points) { this.points = points; }

    public LocalDateTime getEarnedAt() { return earnedAt; }
    public void setEarnedAt(LocalDateTime earnedAt) { this.earnedAt = earnedAt; }

    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }
}

