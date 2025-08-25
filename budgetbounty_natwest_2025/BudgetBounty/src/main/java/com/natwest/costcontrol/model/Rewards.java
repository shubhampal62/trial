package com.natwest.costcontrol.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "rewards")
public class Rewards {

    @Id
    @Column(name = "reward_id", length = 36, nullable = false)
    private String rewardId;

    @Column(name = "user_id", length = 36, nullable = false)
    private String userId;

    @Column(name = "goal_id", length = 36)
    private String goalId;

    @Column(name = "activity_id", length = 36)
    private String activityId;

    @Column(name = "budget_id", length = 36)
    private String budgetId;

    @Column(name = "points", nullable = false)
    private int points;

    @Column(name = "earned_at", nullable = false)
    private LocalDateTime earnedAt;

    @Column(name = "catalog_item_id", length = 36)
    private String catalogItemId;

    @Column(name = "reason", length = 255)
    private String reason;

    // Constructors
    public Rewards() {}

    public Rewards(String rewardId, String userId, String goalId, String activityId, 
                   String budgetId, int points, LocalDateTime earnedAt, 
                   String catalogItemId, String reason) {
        this.rewardId = rewardId;
        this.userId = userId;
        this.goalId = goalId;
        this.activityId = activityId;
        this.budgetId = budgetId;
        this.points = points;
        this.earnedAt = earnedAt;
        this.catalogItemId = catalogItemId;
        this.reason = reason;
    }

    // Getters & Setters
    public String getRewardId() { return rewardId; }
    public void setRewardId(String rewardId) { this.rewardId = rewardId; }

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
