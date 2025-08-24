package com.natwest.costcontrol.repository;

import com.natwest.costcontrol.model.Partner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartnerRepository extends JpaRepository<Partner, String> {
}
