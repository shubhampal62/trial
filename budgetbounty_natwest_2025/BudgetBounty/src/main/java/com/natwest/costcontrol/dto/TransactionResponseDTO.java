package com.natwest.costcontrol.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionResponseDTO {
	private Long txnId;
	private String userId;
	private String categoryId;
	private String budgetId;
	private String accountId;
	private String upiRefId;
	private String recipientId;
	private BigDecimal amount;
	private String txnType;
	private String txnStatus;
	private LocalDateTime txnDate;
	private String txnChannel;
	private Integer rewardsEarned;
	private String merchantName;
	private String description;

	public TransactionResponseDTO() {
	}

	// Getters and setters
	public Long getTxnId() {
		return txnId;
	}

	public void setTxnId(Long txnId) {
		this.txnId = txnId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getBudgetId() {
		return budgetId;
	}

	public void setBudgetId(String budgetId) {
		this.budgetId = budgetId;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getUpiRefId() {
		return upiRefId;
	}

	public void setUpiRefId(String upiRefId) {
		this.upiRefId = upiRefId;
	}

	public String getRecipientId() {
		return recipientId;
	}

	public void setRecipientId(String recipientId) {
		this.recipientId = recipientId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getTxnType() {
		return txnType;
	}

	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}

	public String getTxnStatus() {
		return txnStatus;
	}

	public void setTxnStatus(String txnStatus) {
		this.txnStatus = txnStatus;
	}

	public LocalDateTime getTxnDate() {
		return txnDate;
	}

	public void setTxnDate(LocalDateTime txnDate) {
		this.txnDate = txnDate;
	}

	public String getTxnChannel() {
		return txnChannel;
	}

	public void setTxnChannel(String txnChannel) {
		this.txnChannel = txnChannel;
	}

	public Integer getRewardsEarned() {
		return rewardsEarned;
	}

	public void setRewardsEarned(Integer rewardsEarned) {
		this.rewardsEarned = rewardsEarned;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
