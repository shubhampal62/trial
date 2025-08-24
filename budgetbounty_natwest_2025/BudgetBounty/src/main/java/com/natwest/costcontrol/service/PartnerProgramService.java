package com.natwest.costcontrol.service;

import com.natwest.costcontrol.dto.PartnerProgramRequestDTO;
import com.natwest.costcontrol.dto.PartnerProgramResponseDTO;

import java.util.List;

public interface PartnerProgramService {
    PartnerProgramResponseDTO createProgram(PartnerProgramRequestDTO requestDTO);
    PartnerProgramResponseDTO getProgramById(String programId);
    List<PartnerProgramResponseDTO> getAllPrograms();
    PartnerProgramResponseDTO updateProgram(String programId, PartnerProgramRequestDTO requestDTO);
    void deleteProgram(String programId);
}
