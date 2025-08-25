package com.natwest.costcontrol.service;


import com.natwest.costcontrol.dto.RewardsRequestDTO;
import com.natwest.costcontrol.dto.RewardsResponseDTO;

import java.util.List;

public interface RewardsService {

    RewardsResponseDTO createReward(RewardsRequestDTO requestDTO);

    RewardsResponseDTO getRewardById(String rewardId);

    List<RewardsResponseDTO> getRewardsByUserId(String userId);

    void deleteReward(String rewardId);
}
