package com.natwest.costcontrol.controller;

import com.natwest.costcontrol.dto.PartnerRequestDTO;
import com.natwest.costcontrol.dto.PartnerResponseDTO;
import com.natwest.costcontrol.service.PartnerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/partners")
public class PartnerController {

    private final PartnerService partnerService;

    public PartnerController(PartnerService partnerService) {
        this.partnerService = partnerService;
    }

    @PostMapping
    public ResponseEntity<PartnerResponseDTO> createPartner(@RequestBody PartnerRequestDTO requestDTO) {
        return ResponseEntity.ok(partnerService.createPartner(requestDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PartnerResponseDTO> getPartnerById(@PathVariable String id) {
        PartnerResponseDTO response = partnerService.getPartnerById(id);
        return response != null ? ResponseEntity.ok(response) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<PartnerResponseDTO>> getAllPartners() {
        return ResponseEntity.ok(partnerService.getAllPartners());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PartnerResponseDTO> updatePartner(@PathVariable String id, @RequestBody PartnerRequestDTO requestDTO) {
        PartnerResponseDTO response = partnerService.updatePartner(id, requestDTO);
        return response != null ? ResponseEntity.ok(response) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePartner(@PathVariable String id) {
        partnerService.deletePartner(id);
        return ResponseEntity.noContent().build();
    }
}
