package com.natwest.costcontrol.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transactions_seq")
	@SequenceGenerator(name = "transactions_seq", sequenceName = "transactions_seq", allocationSize = 1)
	@Column(name = "txn_id")
	private Long txnId;

	@Column(name = "user_id", nullable = false)
	private String userId;

	@Column(name = "category_id")
	private String categoryId;

	@Column(name = "budget_id")
	private String budgetId;

	@Column(name = "account_id")
	private String accountId;

	@Column(name = "upi_ref_id")
	private String upiRefId;

	@Column(name = "recipient_id", nullable = false)
	private String recipientId;

	@Column(name = "amount", nullable = false)
	private BigDecimal amount;

	@Column(name = "txn_type", nullable = false)
	private String txnType;

	@Column(name = "txn_status", nullable = false)
	private String txnStatus;

	@Column(name = "txn_date", nullable = false)
	private LocalDateTime txnDate;

	@Column(name = "txn_channel", nullable = false)
	private String txnChannel;

	@Column(name = "rewards_earned", nullable = false)
	private Integer rewardsEarned = 0;

	@Column(name = "merchant_name", length = 200)
	private String merchantName;

	@Column(name = "description", length = 4000)
	private String description;

	public Transaction() {
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
