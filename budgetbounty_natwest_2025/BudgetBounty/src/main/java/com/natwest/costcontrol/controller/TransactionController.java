package com.natwest.costcontrol.controller;

import com.natwest.costcontrol.dto.TransactionRequestDTO;
import com.natwest.costcontrol.dto.TransactionResponseDTO;
import com.natwest.costcontrol.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    // Create new transaction
    @PostMapping
    public ResponseEntity<TransactionResponseDTO> createTransaction(@RequestBody TransactionRequestDTO dto) {
        return ResponseEntity.ok(transactionService.createTransaction(dto));
    }

    // Get transaction by ID
    @GetMapping("/{id}")
    public ResponseEntity<TransactionResponseDTO> getTransactionById(@PathVariable Long id) {
        return ResponseEntity.ok(transactionService.getTransactionById(id));
    }

    // Get all transactions
    @GetMapping
    public ResponseEntity<List<TransactionResponseDTO>> getAllTransactions() {
        return ResponseEntity.ok(transactionService.getAllTransactions());
    }

    // Get transactions by user ID
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<TransactionResponseDTO>> getTransactionsByUser(@PathVariable String userId) {
        return ResponseEntity.ok(transactionService.getTransactionsByUserId(userId));
    }

    // Get transactions by category ID
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<TransactionResponseDTO>> getTransactionsByCategory(@PathVariable String categoryId) {
        return ResponseEntity.ok(transactionService.getTransactionsByCategoryId(categoryId));
    }

    // Get transactions by user ID and category ID
    @GetMapping("/user/{userId}/category/{categoryId}")
    public ResponseEntity<List<TransactionResponseDTO>> getTransactionsByUserAndCategory(
            @PathVariable String userId,
            @PathVariable String categoryId) {
        return ResponseEntity.ok(transactionService.getTransactionsByUserAndCategory(userId, categoryId));
    }

    // Update transaction
    @PutMapping("/{id}")
    public ResponseEntity<TransactionResponseDTO> updateTransaction(
            @PathVariable Long id,
            @RequestBody TransactionRequestDTO dto) {
        return ResponseEntity.ok(transactionService.updateTransaction(id, dto));
    }

    // Delete transaction
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable Long id) {
        transactionService.deleteTransaction(id);
        return ResponseEntity.noContent().build();
    }
}
