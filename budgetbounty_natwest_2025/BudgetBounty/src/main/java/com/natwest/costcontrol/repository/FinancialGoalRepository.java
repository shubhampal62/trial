package com.natwest.costcontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.natwest.costcontrol.model.FinancialGoal;
import java.util.List;

@Repository
public interface FinancialGoalRepository extends JpaRepository<FinancialGoal, String> {
	 List<FinancialGoal> findByUserId(String userId);
}
