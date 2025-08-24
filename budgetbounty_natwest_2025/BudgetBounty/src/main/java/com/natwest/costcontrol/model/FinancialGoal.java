package com.natwest.costcontrol.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "financial_goal")
public class FinancialGoal {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "financial_goals_seq")
    @SequenceGenerator(name = "financial_goals_seq", sequenceName ="financial_goals_seq", allocationSize = 1)
    @Column(name = "goal_id", nullable = false, length = 36)
    private String goalId;

    @Column(name = "user_id", nullable = false, length = 36)
    private String userId;

    @Column(name = "goal_name", nullable = false)
    private String goalName;

    @Enumerated(EnumType.STRING)
    @Column(name = "goal_type")
    private GoalType goalType;

    @Column(name = "target_amount", nullable = false, precision = 19, scale = 2)
    private BigDecimal targetAmount;


	@Column(name = "current_amount", nullable = false, precision = 19, scale = 2)
    private BigDecimal currentAmount = BigDecimal.ZERO;

    @Column(name = "target_date")
    private LocalDate targetDate;

    @Lob
    @Column(name = "custom_attrs")
    private String customAttrs;

    @Column(name = "is_achieved")
    private Boolean isAchieved;

    @Column(name = "domain", nullable = false)
    private String domain;

    public enum GoalType {
        GROCERY, INVESTMENT, INSURANCE
    }
    
    public String getGoalId() {
		return goalId;
	}

	public void setGoalId(String goalId) {
		this.goalId = goalId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getGoalName() {
		return goalName;
	}

	public void setGoalName(String goalName) {
		this.goalName = goalName;
	}

	public GoalType getGoalType() {
		return goalType;
	}

	public void setGoalType(GoalType goalType) {
		this.goalType = goalType;
	}

	public BigDecimal getTargetAmount() {
		return targetAmount;
	}

	public void setTargetAmount(BigDecimal targetAmount) {
		this.targetAmount = targetAmount;
	}

	public BigDecimal getCurrentAmount() {
		return currentAmount;
	}

	public void setCurrentAmount(BigDecimal currentAmount) {
		this.currentAmount = currentAmount;
	}

	public LocalDate getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(LocalDate targetDate) {
		this.targetDate = targetDate;
	}

	public String getCustomAttrs() {
		return customAttrs;
	}

	public void setCustomAttrs(String customAttrs) {
		this.customAttrs = customAttrs;
	}

	public Boolean getIsAchieved() {
		return isAchieved;
	}

	public void setIsAchieved(Boolean isAchieved) {
		this.isAchieved = isAchieved;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}
}

