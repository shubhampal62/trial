package com.natwest.costcontrol.controller;

import com.natwest.costcontrol.dto.FinancialGoalRequestDTO;
import com.natwest.costcontrol.dto.FinancialGoalResponseDTO;
import com.natwest.costcontrol.service.FinancialGoalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/financial-goals")
public class FinancialGoalController {

    @Autowired
    private FinancialGoalService financialGoalService;

    //Create a new financial goal
    @PostMapping
    public ResponseEntity<FinancialGoalResponseDTO> createFinancialGoal(
            @RequestBody FinancialGoalRequestDTO financialRequest) {
        FinancialGoalResponseDTO response = financialGoalService.createFinancialGoal(financialRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    //Get financial goal by ID
    @GetMapping("/{goalId}")
    public ResponseEntity<FinancialGoalResponseDTO> getFinancialGoalById(@PathVariable String goalId) {
        FinancialGoalResponseDTO response = financialGoalService.getFinancialGoalById(goalId);
        return ResponseEntity.ok(response);
    }

    //Get all financial goals
    @GetMapping
    public ResponseEntity<List<FinancialGoalResponseDTO>> getAllFinancialGoals() {
        List<FinancialGoalResponseDTO> goals = financialGoalService.getAllFinancialGoals();
        return ResponseEntity.ok(goals);
    }

    //Update a financial goal
    @PutMapping("/{goalId}")
    public ResponseEntity<FinancialGoalResponseDTO> updateFinancialGoal(
            @PathVariable String goalId,
            @RequestBody FinancialGoalRequestDTO financialRequest) {
        financialRequest.setGoalId(goalId);
        FinancialGoalResponseDTO response = financialGoalService.updateFinancialGoal(financialRequest);
        return ResponseEntity.ok(response);
    }

    //Delete a financial goal
    @DeleteMapping("/{goalId}")
    public ResponseEntity<Void> deleteFinancialGoal(@PathVariable String goalId) {
        financialGoalService.deleteFinancialGoal(goalId);
        return ResponseEntity.noContent().build();
    }
}
