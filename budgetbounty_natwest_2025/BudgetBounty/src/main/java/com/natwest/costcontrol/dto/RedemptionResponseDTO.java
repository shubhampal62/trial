package com.natwest.costcontrol.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RedemptionResponseDTO {
	private Long redemptionId;
	private Long userId;
	private Long catalogItemId;
	private Long programId;
	private Integer pointsRedeemed;
	private BigDecimal redemptionValue;
	private String redemptionCode;
	private String status;
	private LocalDateTime redeemedAt;
	private LocalDateTime expiryDate;
	private String fulfillmentDetails;
	private String failureReason;

	// Getters & setters
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
