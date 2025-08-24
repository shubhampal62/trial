package com.natwest.costcontrol.service.impl;

import com.natwest.costcontrol.dto.PartnerRequestDTO;
import com.natwest.costcontrol.dto.PartnerResponseDTO;
import com.natwest.costcontrol.model.Partner;
import com.natwest.costcontrol.repository.PartnerRepository;
import com.natwest.costcontrol.service.PartnerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PartnerServiceImpl implements PartnerService {

    private final PartnerRepository partnerRepository;

    public PartnerServiceImpl(PartnerRepository partnerRepository) {
        this.partnerRepository = partnerRepository;
    }

    @Override
    public PartnerResponseDTO createPartner(PartnerRequestDTO requestDTO) {
        Partner partner = new Partner();
        partner.setPartnerId(java.util.UUID.randomUUID().toString());
        partner.setName(requestDTO.getName());
        partner.setApiKey(requestDTO.getApiKey());

        Partner saved = partnerRepository.save(partner);
        return new PartnerResponseDTO(saved.getPartnerId(), saved.getName(), saved.getApiKey());
    }

    @Override
    public PartnerResponseDTO getPartnerById(String partnerId) {
        Optional<Partner> partnerOpt = partnerRepository.findById(partnerId);
        return partnerOpt.map(p -> new PartnerResponseDTO(p.getPartnerId(), p.getName(), p.getApiKey())).orElse(null);
    }

    @Override
    public List<PartnerResponseDTO> getAllPartners() {
        return partnerRepository.findAll().stream()
                .map(p -> new PartnerResponseDTO(p.getPartnerId(), p.getName(), p.getApiKey()))
                .collect(Collectors.toList());
    }

    @Override
    public PartnerResponseDTO updatePartner(String partnerId, PartnerRequestDTO requestDTO) {
        Optional<Partner> partnerOpt = partnerRepository.findById(partnerId);
        if (partnerOpt.isPresent()) {
            Partner partner = partnerOpt.get();
            partner.setName(requestDTO.getName());
            partner.setApiKey(requestDTO.getApiKey());
            Partner updated = partnerRepository.save(partner);
            return new PartnerResponseDTO(updated.getPartnerId(), updated.getName(), updated.getApiKey());
        }
        return null;
    }

    @Override
    public void deletePartner(String partnerId) {
        partnerRepository.deleteById(partnerId);
    }
}
