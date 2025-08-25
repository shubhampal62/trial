package com.natwest.costcontrol.service.impl;



import com.natwest.costcontrol.dto.RewardsRequestDTO;
import com.natwest.costcontrol.dto.RewardsResponseDTO;
import com.natwest.costcontrol.model.Rewards;
import com.natwest.costcontrol.repository.RewardsRepository;
import com.natwest.costcontrol.service.RewardsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class RewardsServiceImpl implements RewardsService {

    private final RewardsRepository rewardsRepository;

    public RewardsServiceImpl(RewardsRepository rewardsRepository) {
        this.rewardsRepository = rewardsRepository;
    }

    @Override
    public RewardsResponseDTO createReward(RewardsRequestDTO requestDTO) {
        Rewards reward = new Rewards();
        reward.setRewardId(UUID.randomUUID().toString());
        reward.setUserId(requestDTO.getUserId());
        reward.setGoalId(requestDTO.getGoalId());
        reward.setActivityId(requestDTO.getActivityId());
        reward.setBudgetId(requestDTO.getBudgetId());
        reward.setPoints(requestDTO.getPoints());
        reward.setEarnedAt(requestDTO.getEarnedAt());
        reward.setCatalogItemId(requestDTO.getCatalogItemId());
        reward.setReason(requestDTO.getReason());

        Rewards saved = rewardsRepository.save(reward);
        return new RewardsResponseDTO(saved.getRewardId(), saved.getUserId(),
                saved.getPoints(), saved.getEarnedAt(), saved.getReason());
    }

    @Override
    public RewardsResponseDTO getRewardById(String rewardId) {
        Rewards reward = rewardsRepository.findById(rewardId)
                .orElseThrow(() -> new RuntimeException("Reward not found: " + rewardId));
        return new RewardsResponseDTO(reward.getRewardId(), reward.getUserId(),
                reward.getPoints(), reward.getEarnedAt(), reward.getReason());
    }

    @Override
    public List<RewardsResponseDTO> getRewardsByUserId(String userId) {
        return rewardsRepository.findByUserId(userId).stream()
                .map(r -> new RewardsResponseDTO(r.getRewardId(), r.getUserId(),
                        r.getPoints(), r.getEarnedAt(), r.getReason()))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteReward(String rewardId) {
        if (!rewardsRepository.existsById(rewardId)) {
            throw new RuntimeException("Reward not found: " + rewardId);
        }
        rewardsRepository.deleteById(rewardId);
    }
}

