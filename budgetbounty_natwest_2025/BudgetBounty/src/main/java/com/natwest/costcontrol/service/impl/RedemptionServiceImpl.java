package com.natwest.costcontrol.service.impl;

import com.natwest.costcontrol.dto.RedemptionRequestDTO;
import com.natwest.costcontrol.dto.RedemptionResponseDTO;
import com.natwest.costcontrol.model.Redemption;
import com.natwest.costcontrol.repository.RedemptionRepository;
import com.natwest.costcontrol.service.RedemptionService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RedemptionServiceImpl implements RedemptionService {

    @Autowired
    private RedemptionRepository redemptionRepository;

    private RedemptionResponseDTO mapToDTO(Redemption redemption) {
        RedemptionResponseDTO dto = new RedemptionResponseDTO();
        dto.setRedemptionId(redemption.getRedemptionId());
        dto.setUserId(redemption.getUserId());
        dto.setCatalogItemId(redemption.getCatalogItemId());
        dto.setProgramId(redemption.getProgramId());
        dto.setPointsRedeemed(redemption.getPointsRedeemed());
        dto.setRedemptionValue(redemption.getRedemptionValue());
        dto.setRedemptionCode(redemption.getRedemptionCode());
        dto.setStatus(redemption.getStatus());
        dto.setRedeemedAt(redemption.getRedeemedAt());
        dto.setExpiryDate(redemption.getExpiryDate());
        dto.setFulfillmentDetails(redemption.getFulfillmentDetails());
        dto.setFailureReason(redemption.getFailureReason());
        return dto;
    }

    private Redemption mapToEntity(RedemptionRequestDTO dto) {
        Redemption redemption = new Redemption();
        redemption.setUserId(dto.getUserId());
        redemption.setCatalogItemId(dto.getCatalogItemId());
        redemption.setProgramId(dto.getProgramId());
        redemption.setPointsRedeemed(dto.getPointsRedeemed());
        redemption.setRedemptionValue(dto.getRedemptionValue());
        redemption.setRedemptionCode(dto.getRedemptionCode());
        redemption.setStatus(dto.getStatus());
        redemption.setRedeemedAt(dto.getRedeemedAt());
        redemption.setExpiryDate(dto.getExpiryDate());
        redemption.setFulfillmentDetails(dto.getFulfillmentDetails());
        redemption.setFailureReason(dto.getFailureReason());
        return redemption;
    }

    @Override
    public RedemptionResponseDTO createRedemption(RedemptionRequestDTO request) {
        Redemption redemption = mapToEntity(request);
        return mapToDTO(redemptionRepository.save(redemption));
    }

    @Override
    public RedemptionResponseDTO getRedemptionById(Long id) {
        return redemptionRepository.findById(id)
                .map(this::mapToDTO)
                .orElse(null);
    }

    @Override
    public List<RedemptionResponseDTO> getAllRedemptions() {
        return redemptionRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<RedemptionResponseDTO> getRedemptionsByUser(Long userId) {
        return redemptionRepository.findByUserId(userId).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public RedemptionResponseDTO updateRedemption(Long id, RedemptionRequestDTO request) {
        return redemptionRepository.findById(id).map(redemption -> {
            redemption.setUserId(request.getUserId());
            redemption.setCatalogItemId(request.getCatalogItemId());
            redemption.setProgramId(request.getProgramId());
            redemption.setPointsRedeemed(request.getPointsRedeemed());
            redemption.setRedemptionValue(request.getRedemptionValue());
            redemption.setRedemptionCode(request.getRedemptionCode());
            redemption.setStatus(request.getStatus());
            redemption.setRedeemedAt(request.getRedeemedAt());
            redemption.setExpiryDate(request.getExpiryDate());
            redemption.setFulfillmentDetails(request.getFulfillmentDetails());
            redemption.setFailureReason(request.getFailureReason());
            return mapToDTO(redemptionRepository.save(redemption));
        }).orElse(null);
    }

    @Override
    public void deleteRedemption(Long id) {
        redemptionRepository.deleteById(id);
    }
}
