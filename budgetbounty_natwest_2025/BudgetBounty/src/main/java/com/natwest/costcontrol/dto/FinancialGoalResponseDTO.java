package com.natwest.costcontrol.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.natwest.costcontrol.model.FinancialGoal.GoalType;

public class FinancialGoalResponseDTO {
	private String goalId;
	private String userId;
	private String goalName;
	private GoalType goalType;
	private BigDecimal targetAmount;
	private BigDecimal currentAmount;
	private LocalDate targetDate;
	private String customAttrs;
	private Boolean isAchieved;
	private String domain;
	
	public FinancialGoalResponseDTO() {
		
	}
	
	 public FinancialGoalResponseDTO(String goalId, String userId, String goalName, GoalType goalType,
             BigDecimal targetAmount, BigDecimal currentAmount, LocalDate targetDate,
             Boolean isAchieved, String domain) {
this.goalId = goalId;
this.userId = userId;
this.goalName = goalName;
this.goalType = goalType;
this.targetAmount = targetAmount;
this.currentAmount = currentAmount;
this.targetDate = targetDate;
this.isAchieved = isAchieved;
this.domain = domain;
}
	
	
	//Getters and Setters
	
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
