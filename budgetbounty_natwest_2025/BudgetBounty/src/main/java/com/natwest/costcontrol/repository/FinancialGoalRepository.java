package com.natwest.costcontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.natwest.costcontrol.model.FinancialGoal;

@Repository
public interface FinancialGoalRepository extends JpaRepository<FinancialGoal, String> {
	
}
