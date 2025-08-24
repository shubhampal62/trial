package com.natwest.costcontrol.service;

import com.natwest.costcontrol.dto.TransactionRequestDTO;
import com.natwest.costcontrol.dto.TransactionResponseDTO;

import java.util.List;

public interface TransactionService {
    TransactionResponseDTO createTransaction(TransactionRequestDTO request);
    List<TransactionResponseDTO> getAllTransactions();
    TransactionResponseDTO getTransactionById(Long id);
    List<TransactionResponseDTO> getTransactionsByUser(Long userId);
    List<TransactionResponseDTO> getTransactionsByCategory(Long categoryId);
    TransactionResponseDTO updateTransaction(Long id, TransactionRequestDTO request);
    void deleteTransaction(Long id);
}
