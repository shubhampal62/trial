package com.natwest.costcontrol.controller;

import com.natwest.costcontrol.dto.PartnerProgramRequestDTO;
import com.natwest.costcontrol.dto.PartnerProgramResponseDTO;
import com.natwest.costcontrol.service.PartnerProgramService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/programs")
public class PartnerProgramController {

    private final PartnerProgramService service;

    public PartnerProgramController(PartnerProgramService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<PartnerProgramResponseDTO> createProgram(@RequestBody PartnerProgramRequestDTO requestDTO) {
        return ResponseEntity.ok(service.createProgram(requestDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PartnerProgramResponseDTO> getProgramById(@PathVariable String id) {
        PartnerProgramResponseDTO response = service.getProgramById(id);
        return response != null ? ResponseEntity.ok(response) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<PartnerProgramResponseDTO>> getAllPrograms() {
        return ResponseEntity.ok(service.getAllPrograms());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PartnerProgramResponseDTO> updateProgram(@PathVariable String id,
                                                                    @RequestBody PartnerProgramRequestDTO requestDTO) {
        PartnerProgramResponseDTO response = service.updateProgram(id, requestDTO);
        return response != null ? ResponseEntity.ok(response) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProgram(@PathVariable String id) {
        service.deleteProgram(id);
        return ResponseEntity.noContent().build();
    }
}
