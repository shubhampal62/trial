package com.natwest.costcontrol.controller;

import com.natwest.costcontrol.dto.RedemptionRequestDTO;
import com.natwest.costcontrol.dto.RedemptionResponseDTO;
import com.natwest.costcontrol.service.RedemptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/redemptions")
public class RedemptionController {

    @Autowired
    private RedemptionService redemptionService;

    @PostMapping
    public RedemptionResponseDTO create(@RequestBody RedemptionRequestDTO request) {
        return redemptionService.createRedemption(request);
    }

    @GetMapping("/{id}")
    public RedemptionResponseDTO getById(@PathVariable Long id) {
        return redemptionService.getRedemptionById(id);
    }

    @GetMapping
    public List<RedemptionResponseDTO> getAll() {
        return redemptionService.getAllRedemptions();
    }

    @GetMapping("/user/{userId}")
    public List<RedemptionResponseDTO> getByUser(@PathVariable Long userId) {
        return redemptionService.getRedemptionsByUser(userId);
    }

    @PutMapping("/{id}")
    public RedemptionResponseDTO update(@PathVariable Long id, @RequestBody RedemptionRequestDTO request) {
        return redemptionService.updateRedemption(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        redemptionService.deleteRedemption(id);
    }
}
