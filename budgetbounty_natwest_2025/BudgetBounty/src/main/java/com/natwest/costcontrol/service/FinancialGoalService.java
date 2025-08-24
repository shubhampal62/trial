package com.natwest.costcontrol.service;

import java.util.List;

import com.natwest.costcontrol.dto.FinancialGoalRequestDTO;
import com.natwest.costcontrol.dto.FinancialGoalResponseDTO;

public interface FinancialGoalService {
	FinancialGoalResponseDTO createFinancialGoal(FinancialGoalRequestDTO financialRequest);
	FinancialGoalResponseDTO getFinancialGoalById(String goalId);
	List<FinancialGoalResponseDTO> getAllFinancialGoals();
	FinancialGoalResponseDTO updateFinancialGoal(FinancialGoalRequestDTO finanacialRequest);
	void deleteFinancialGoal(String goalId);
}
