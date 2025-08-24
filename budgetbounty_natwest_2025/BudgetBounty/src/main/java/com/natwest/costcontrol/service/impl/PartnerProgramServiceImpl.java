package com.natwest.costcontrol.service.impl;

import com.natwest.costcontrol.dto.PartnerProgramRequestDTO;
import com.natwest.costcontrol.dto.PartnerProgramResponseDTO;
import com.natwest.costcontrol.model.PartnerProgram;
import com.natwest.costcontrol.repository.PartnerProgramRepository;
import com.natwest.costcontrol.service.PartnerProgramService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PartnerProgramServiceImpl implements PartnerProgramService {

    private final PartnerProgramRepository repository;

    public PartnerProgramServiceImpl(PartnerProgramRepository repository) {
        this.repository = repository;
    }

    @Override
    public PartnerProgramResponseDTO createProgram(PartnerProgramRequestDTO requestDTO) {
        PartnerProgram program = new PartnerProgram();
        program.setProgramId(java.util.UUID.randomUUID().toString());
        program.setProgramName(requestDTO.getProgramName());
        program.setProgramType(requestDTO.getProgramType());
        program.setDescription(requestDTO.getDescription());
        program.setConversionRate(requestDTO.getConversionRate());
        program.setMinimumPoints(requestDTO.getMinimumPoints());
        program.setPartnerId(requestDTO.getPartnerId());

        PartnerProgram saved = repository.save(program);
        return toResponseDTO(saved);
    }

    @Override
    public PartnerProgramResponseDTO getProgramById(String programId) {
        Optional<PartnerProgram> programOpt = repository.findById(programId);
        return programOpt.map(this::toResponseDTO).orElse(null);
    }

    @Override
    public List<PartnerProgramResponseDTO> getAllPrograms() {
        return repository.findAll().stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PartnerProgramResponseDTO updateProgram(String programId, PartnerProgramRequestDTO requestDTO) {
        Optional<PartnerProgram> programOpt = repository.findById(programId);
        if (programOpt.isPresent()) {
            PartnerProgram program = programOpt.get();
            program.setProgramName(requestDTO.getProgramName());
            program.setProgramType(requestDTO.getProgramType());
            program.setDescription(requestDTO.getDescription());
            program.setConversionRate(requestDTO.getConversionRate());
            program.setMinimumPoints(requestDTO.getMinimumPoints());
            program.setPartnerId(requestDTO.getPartnerId());

            PartnerProgram updated = repository.save(program);
            return toResponseDTO(updated);
        }
        return null;
    }

    @Override
    public void deleteProgram(String programId) {
        repository.deleteById(programId);
    }

    private PartnerProgramResponseDTO toResponseDTO(PartnerProgram program) {
        return new PartnerProgramResponseDTO(
                program.getProgramId(),
                program.getProgramName(),
                program.getProgramType(),
                program.getDescription(),
                program.getConversionRate(),
                program.getMinimumPoints(),
                program.getPartnerId()
        );
    }
}
