package com.natwest.costcontrol.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.natwest.costcontrol.dto.ReferralRequestDTO;
import com.natwest.costcontrol.dto.ReferralResponseDTO;
import com.natwest.costcontrol.model.Referral;
import com.natwest.costcontrol.repository.ReferralRepository;
import com.natwest.costcontrol.service.ReferralService;

@Service
public class ReferralServiceImpl implements ReferralService {

    private final ReferralRepository referralRepository;

    public ReferralServiceImpl(ReferralRepository referralRepository) {
        this.referralRepository = referralRepository;
    }

    @Override
    public ReferralResponseDTO createReferral(ReferralRequestDTO requestDTO) {
        Referral referral = new Referral();
        referral.setReferralId(UUID.randomUUID().toString());
        referral.setReferrerUserId(requestDTO.getReferrerUserId());
        referral.setReferredEmail(requestDTO.getReferredEmail());
        referral.setReferralCode(requestDTO.getReferralCode());
        referral.setStatus(requestDTO.getStatus());
        referral.setRewardPoints(requestDTO.getRewardPoints());

        Referral saved = referralRepository.save(referral);
        return mapToResponseDTO(saved);
    }

    @Override
    public ReferralResponseDTO getReferralById(String id) {
        Optional<Referral> referralOpt = referralRepository.findById(id);
        return referralOpt.map(this::mapToResponseDTO)
                .orElseThrow(() -> new RuntimeException("Referral not found with id " + id));
    }

    @Override
    public List<ReferralResponseDTO> getAllReferrals() {
        return referralRepository.findAll().stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ReferralResponseDTO> getReferralsByReferrerUserId(String referrerUserId) {
        return referralRepository.findByReferrerUserId(referrerUserId).stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ReferralResponseDTO> getReferralsByReferredEmail(String referredEmail) {
        return referralRepository.findByReferredEmail(referredEmail).stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ReferralResponseDTO getReferralByCode(String referralCode) {
        Optional<Referral> referralOpt = referralRepository.findByReferralCode(referralCode);
        return referralOpt.map(this::mapToResponseDTO)
                .orElseThrow(() -> new RuntimeException("Referral not found with code " + referralCode));
    }

    @Override
    public ReferralResponseDTO updateReferral(String id, ReferralRequestDTO requestDTO) {
        Optional<Referral> referralOpt = referralRepository.findById(id);
        if (referralOpt.isPresent()) {
            Referral referral = referralOpt.get();
            referral.setReferrerUserId(requestDTO.getReferrerUserId());
            referral.setReferredEmail(requestDTO.getReferredEmail());
            referral.setReferralCode(requestDTO.getReferralCode());
            referral.setStatus(requestDTO.getStatus());
            referral.setRewardPoints(requestDTO.getRewardPoints());

            Referral updated = referralRepository.save(referral);
            return mapToResponseDTO(updated);
        }
        throw new RuntimeException("Referral not found with id " + id);
    }

    @Override
    public void deleteReferral(String id) {
        if (!referralRepository.existsById(id)) {
            throw new RuntimeException("Referral not found with id " + id);
        }
        referralRepository.deleteById(id);
    }

    private ReferralResponseDTO mapToResponseDTO(Referral referral) {
        ReferralResponseDTO dto = new ReferralResponseDTO();
        dto.setReferralId(referral.getReferralId());
        dto.setReferrerUserId(referral.getReferrerUserId());
        dto.setReferredEmail(referral.getReferredEmail());
        dto.setReferralCode(referral.getReferralCode());
        dto.setStatus(referral.getStatus());
        dto.setRewardPoints(referral.getRewardPoints());
        return dto;
    }
}