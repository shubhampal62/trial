package com.natwest.costcontrol.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "redemptions")
@SequenceGenerator(name = "redemptions_seq", sequenceName = "redemptions_seq", allocationSize = 1)
public class Redemption {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "redemptions_seq")
	@Column(name = "redemption_id")
	private Long redemptionId;

	@Column(name = "user_id", nullable = false)
	private Long userId;

	@Column(name = "catalog_item_id", nullable = false)
	private Long catalogItemId;

	@Column(name = "program_id", nullable = false)
	private Long programId;

	@Column(name = "points_redeemed", nullable = false)
	private Integer pointsRedeemed;

	@Column(name = "redemption_value", precision = 19, scale = 2)
	private BigDecimal redemptionValue;

	@Column(name = "redemption_code", length = 255)
	private String redemptionCode;

	@Column(name = "status", length = 50)
	private String status;

	private LocalDateTime redeemedAt;

	private LocalDateTime expiryDate;

	@Column(name = "fulfillment_details", columnDefinition = "CLOB")
	private String fulfillmentDetails;

	@Column(name = "failure_reason", columnDefinition = "CLOB")
	private String failureReason;

	// Getters and setters
	public Long getRedemptionId() {
		return redemptionId;
	}

	public void setRedemptionId(Long redemptionId) {
		this.redemptionId = redemptionId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getCatalogItemId() {
		return catalogItemId;
	}

	public void setCatalogItemId(Long catalogItemId) {
		this.catalogItemId = catalogItemId;
	}

	public Long getProgramId() {
		return programId;
	}

	public void setProgramId(Long programId) {
		this.programId = programId;
	}

	public Integer getPointsRedeemed() {
		return pointsRedeemed;
	}

	public void setPointsRedeemed(Integer pointsRedeemed) {
		this.pointsRedeemed = pointsRedeemed;
	}

	public BigDecimal getRedemptionValue() {
		return redemptionValue;
	}

	public void setRedemptionValue(BigDecimal redemptionValue) {
		this.redemptionValue = redemptionValue;
	}

	public String getRedemptionCode() {
		return redemptionCode;
	}

	public void setRedemptionCode(String redemptionCode) {
		this.redemptionCode = redemptionCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getRedeemedAt() {
		return redeemedAt;
	}

	public void setRedeemedAt(LocalDateTime redeemedAt) {
		this.redeemedAt = redeemedAt;
	}

	public LocalDateTime getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDateTime expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getFulfillmentDetails() {
		return fulfillmentDetails;
	}

	public void setFulfillmentDetails(String fulfillmentDetails) {
		this.fulfillmentDetails = fulfillmentDetails;
	}

	public String getFailureReason() {
		return failureReason;
	}

	public void setFailureReason(String failureReason) {
		this.failureReason = failureReason;
	}
}
