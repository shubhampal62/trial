package com.natwest.costcontrol.repository;

import com.natwest.costcontrol.model.Redemption;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RedemptionRepository extends JpaRepository<Redemption, Long> {
    List<Redemption> findByUserId(Long userId);
}
