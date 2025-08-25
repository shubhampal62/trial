package com.natwest.costcontrol.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.natwest.costcontrol.dto.ReferralRequestDTO;
import com.natwest.costcontrol.dto.ReferralResponseDTO;
import com.natwest.costcontrol.service.ReferralService;

@RestController
@RequestMapping("/api/referrals")
public class ReferralController {

    private final ReferralService referralService;

    public ReferralController(ReferralService referralService) {
        this.referralService = referralService;
    }

    @PostMapping
    public ResponseEntity<ReferralResponseDTO> createReferral(@RequestBody ReferralRequestDTO requestDTO) {
        return ResponseEntity.ok(referralService.createReferral(requestDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReferralResponseDTO> getReferralById(@PathVariable String id) {
        return ResponseEntity.ok(referralService.getReferralById(id));
    }

    @GetMapping
    public ResponseEntity<List<ReferralResponseDTO>> getAllReferrals() {
        return ResponseEntity.ok(referralService.getAllReferrals());
    }

    @GetMapping("/referrer/{referrerUserId}")
    public ResponseEntity<List<ReferralResponseDTO>> getReferralsByReferrerUserId(@PathVariable String referrerUserId) {
        return ResponseEntity.ok(referralService.getReferralsByReferrerUserId(referrerUserId));
    }

    @GetMapping("/email/{referredEmail}")
    public ResponseEntity<List<ReferralResponseDTO>> getReferralsByReferredEmail(@PathVariable String referredEmail) {
        return ResponseEntity.ok(referralService.getReferralsByReferredEmail(referredEmail));
    }

    @GetMapping("/code/{referralCode}")
    public ResponseEntity<ReferralResponseDTO> getReferralByCode(@PathVariable String referralCode) {
        return ResponseEntity.ok(referralService.getReferralByCode(referralCode));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReferralResponseDTO> updateReferral(@PathVariable String id, @RequestBody ReferralRequestDTO requestDTO) {
        return ResponseEntity.ok(referralService.updateReferral(id, requestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReferral(@PathVariable String id) {
        referralService.deleteReferral(id);
        return ResponseEntity.noContent().build();
    }
}