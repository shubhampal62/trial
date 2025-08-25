package com.natwest.costcontrol.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.natwest.costcontrol.dto.FinancialGoalRequestDTO;
import com.natwest.costcontrol.dto.FinancialGoalResponseDTO;
import com.natwest.costcontrol.model.FinancialGoal;
import com.natwest.costcontrol.repository.FinancialGoalRepository;
import com.natwest.costcontrol.service.FinancialGoalService;

@Service
public class FinancialGoalServiceImpl implements FinancialGoalService {

    @Autowired
    private FinancialGoalRepository financialGoalRepository;

    @Override
    public FinancialGoalResponseDTO createFinancialGoal(FinancialGoalRequestDTO financialRequest) {
        FinancialGoal goal = new FinancialGoal();
        goal.setGoalId(financialRequest.getGoalId());
        goal.setGoalName(financialRequest.getGoalName());
        goal.setTargetAmount(financialRequest.getTargetAmount());
        goal.setCurrentAmount(financialRequest.getCurrentAmount());
        goal.setTargetDate(financialRequest.getTargetDate());

        FinancialGoal savedGoal = financialGoalRepository.save(goal);

        return mapToResponseDTO(savedGoal);
    }

    @Override
    public FinancialGoalResponseDTO getFinancialGoalById(String goalId) {
        Optional<FinancialGoal> goal = financialGoalRepository.findById(goalId);
        return goal.map(this::mapToResponseDTO).orElse(null);
    }

    @Override
    public List<FinancialGoalResponseDTO> getAllFinancialGoals() {
        return financialGoalRepository.findAll()
                .stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public FinancialGoalResponseDTO updateFinancialGoal(FinancialGoalRequestDTO financialRequest) {
        Optional<FinancialGoal> existingGoalOpt = financialGoalRepository.findById(financialRequest.getGoalId());

        if (existingGoalOpt.isPresent()) {
            FinancialGoal existingGoal = existingGoalOpt.get();
            existingGoal.setGoalName(financialRequest.getGoalName());
            existingGoal.setTargetAmount(financialRequest.getTargetAmount());
            existingGoal.setCurrentAmount(financialRequest.getCurrentAmount());
            existingGoal.setTargetDate(financialRequest.getTargetDate());

            FinancialGoal updatedGoal = financialGoalRepository.save(existingGoal);

            return mapToResponseDTO(updatedGoal);
        }
        return null; // or throw custom exception
    }

    @Override
    public void deleteFinancialGoal(String goalId) {
        financialGoalRepository.deleteById(goalId);
    }

    // Utility method to convert Entity → ResponseDTO
    private FinancialGoalResponseDTO mapToResponseDTO(FinancialGoal goal) {
        FinancialGoalResponseDTO response = new FinancialGoalResponseDTO();
        response.setGoalId(goal.getGoalId());
        response.setGoalName(goal.getGoalName());
        response.setTargetAmount(goal.getTargetAmount());
        response.setCurrentAmount(goal.getCurrentAmount());
        response.setTargetDate(goal.getTargetDate());
        return response;
    }
}
