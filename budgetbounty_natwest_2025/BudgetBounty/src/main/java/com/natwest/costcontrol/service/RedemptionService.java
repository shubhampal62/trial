package com.natwest.costcontrol.service;

import com.natwest.costcontrol.dto.RedemptionRequestDTO;
import com.natwest.costcontrol.dto.RedemptionResponseDTO;
import java.util.List;

public interface RedemptionService {
    RedemptionResponseDTO createRedemption(RedemptionRequestDTO request);
    RedemptionResponseDTO getRedemptionById(Long id);
    List<RedemptionResponseDTO> getAllRedemptions();
    List<RedemptionResponseDTO> getRedemptionsByUser(Long userId);
    RedemptionResponseDTO updateRedemption(Long id, RedemptionRequestDTO request);
    void deleteRedemption(Long id);
}
