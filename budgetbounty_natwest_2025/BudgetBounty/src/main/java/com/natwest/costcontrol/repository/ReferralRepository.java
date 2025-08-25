package com.natwest.costcontrol.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.natwest.costcontrol.model.Referral;

@Repository
public interface ReferralRepository extends JpaRepository<Referral, String> {
    List<Referral> findByReferrerUserId(String referrerUserId);
    List<Referral> findByReferredEmail(String referredEmail);
    Optional<Referral> findByReferralCode(String referralCode);
}