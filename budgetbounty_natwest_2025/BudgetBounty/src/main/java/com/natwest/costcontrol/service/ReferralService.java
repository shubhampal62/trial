package com.natwest.costcontrol.service;

import java.util.List;

import com.natwest.costcontrol.dto.ReferralRequestDTO;
import com.natwest.costcontrol.dto.ReferralResponseDTO;

public interface ReferralService {
    ReferralResponseDTO createReferral(ReferralRequestDTO requestDTO);
    ReferralResponseDTO getReferralById(String id);
    List<ReferralResponseDTO> getAllReferrals();
    List<ReferralResponseDTO> getReferralsByReferrerUserId(String referrerUserId);
    List<ReferralResponseDTO> getReferralsByReferredEmail(String referredEmail);
    ReferralResponseDTO getReferralByCode(String referralCode);
    ReferralResponseDTO updateReferral(String id, ReferralRequestDTO requestDTO);
    void deleteReferral(String id);
}