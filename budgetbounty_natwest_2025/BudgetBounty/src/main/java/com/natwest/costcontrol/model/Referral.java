package com.natwest.costcontrol.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "referrals")
public class Referral {

    public enum ReferralStatus {
        PENDING, COMPLETED
    }

    @Id
    @Column(name = "referral_id", length = 36)
    private String referralId;

    @Column(name = "referrer_user_id", length = 36, nullable = false)
    private String referrerUserId;

    @Column(name = "referred_email", nullable = false, length = 255)
    private String referredEmail;

    @Column(name = "referral_code", nullable = false, unique = true, length = 100)
    private String referralCode;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    private ReferralStatus status;

    @Column(name = "reward_points", nullable = false)
    private Integer rewardPoints = 0;

    // Constructors
    public Referral() {}

    public Referral(String referralId, String referrerUserId, String referredEmail, 
                   String referralCode, ReferralStatus status, Integer rewardPoints) {
        this.referralId = referralId;
        this.referrerUserId = referrerUserId;
        this.referredEmail = referredEmail;
        this.referralCode = referralCode;
        this.status = status;
        this.rewardPoints = rewardPoints;
    }

    // Getters and Setters
    public String getReferralId() {
        return referralId;
    }

    public void setReferralId(String referralId) {
        this.referralId = referralId;
    }

    public String getReferrerUserId() {
        return referrerUserId;
    }

    public void setReferrerUserId(String referrerUserId) {
        this.referrerUserId = referrerUserId;
    }

    public String getReferredEmail() {
        return referredEmail;
    }

    public void setReferredEmail(String referredEmail) {
        this.referredEmail = referredEmail;
    }

    public String getReferralCode() {
        return referralCode;
    }

    public void setReferralCode(String referralCode) {
        this.referralCode = referralCode;
    }

    public ReferralStatus getStatus() {
        return status;
    }

    public void setStatus(ReferralStatus status) {
        this.status = status;
    }

    public Integer getRewardPoints() {
        return rewardPoints;
    }

    public void setRewardPoints(Integer rewardPoints) {
        this.rewardPoints = rewardPoints;
    }
}