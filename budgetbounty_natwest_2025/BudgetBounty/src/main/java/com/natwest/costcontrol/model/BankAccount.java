package com.natwest.costcontrol.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "bank_account")
public class BankAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bank_account_seq")
	@SequenceGenerator(name = "bank_account_seq", sequenceName = "bank_account_seq", allocationSize = 1)
	@Column(name = "account_id")
	private Long accountId;

	@Column(name = "user_id", nullable = false)
	private Long userId;

	@Column(name = "account_number", nullable = false, unique = true, length = 50)
	private String accountNumber;

	@Column(name = "account_type", nullable = false, length = 50)
	private String accountType; // e.g. SAVINGS, CURRENT

	@Column(name = "balance", nullable = false, precision = 19, scale = 2)
	private BigDecimal balance;

	@Column(name = "bank_name", nullable = false)
	private String bankName;

	@Column(name = "ifsc", nullable = false, length = 20)
	private String ifsc;

	@Column(name = "account_name", nullable = false)
	private String accountName; // nickname

	// Getters & Setters
	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
}
