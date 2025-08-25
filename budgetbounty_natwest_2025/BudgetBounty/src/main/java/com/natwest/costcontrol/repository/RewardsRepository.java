package com.natwest.costcontrol.repository;

import com.natwest.costcontrol.model.Rewards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RewardsRepository extends JpaRepository<Rewards, String> {
    List<Rewards> findByUserId(String userId);
}
