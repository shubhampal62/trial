package com.natwest.costcontrol.service;

import com.natwest.costcontrol.dto.PartnerRequestDTO;
import com.natwest.costcontrol.dto.PartnerResponseDTO;

import java.util.List;

public interface PartnerService {
    PartnerResponseDTO createPartner(PartnerRequestDTO requestDTO);
    PartnerResponseDTO getPartnerById(String partnerId);
    List<PartnerResponseDTO> getAllPartners();
    PartnerResponseDTO updatePartner(String partnerId, PartnerRequestDTO requestDTO);
    void deletePartner(String partnerId);
}
