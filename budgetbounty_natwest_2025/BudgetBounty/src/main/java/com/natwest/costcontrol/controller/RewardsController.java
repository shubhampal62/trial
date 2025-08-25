package com.natwest.costcontrol.controller;


import com.natwest.costcontrol.dto.RewardsRequestDTO;
import com.natwest.costcontrol.dto.RewardsResponseDTO;
import com.natwest.costcontrol.service.RewardsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rewards")
public class RewardsController {

    private final RewardsService rewardsService;

    public RewardsController(RewardsService rewardsService) {
        this.rewardsService = rewardsService;
    }

    @PostMapping
    public ResponseEntity<RewardsResponseDTO> createReward(@RequestBody RewardsRequestDTO requestDTO) {
        return ResponseEntity.ok(rewardsService.createReward(requestDTO));
    }

    @GetMapping("/{rewardId}")
    public ResponseEntity<RewardsResponseDTO> getRewardById(@PathVariable String rewardId) {
        return ResponseEntity.ok(rewardsService.getRewardById(rewardId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<RewardsResponseDTO>> getRewardsByUserId(@PathVariable String userId) {
        return ResponseEntity.ok(rewardsService.getRewardsByUserId(userId));
    }

    @DeleteMapping("/{rewardId}")
    public ResponseEntity<Void> deleteReward(@PathVariable String rewardId) {
        rewardsService.deleteReward(rewardId);
        return ResponseEntity.noContent().build();
    }
}
