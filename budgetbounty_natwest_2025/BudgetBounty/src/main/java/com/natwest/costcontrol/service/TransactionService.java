package com.natwest.costcontrol.service;

import com.natwest.costcontrol.dto.TransactionRequestDTO;
import com.natwest.costcontrol.dto.TransactionResponseDTO;
import java.util.List;

public interface TransactionService {
    TransactionResponseDTO createTransaction(TransactionRequestDTO dto);
    TransactionResponseDTO getTransactionById(Long txnId);
    List<TransactionResponseDTO> getAllTransactions();
    List<TransactionResponseDTO> getTransactionsByUserId(String userId);
    List<TransactionResponseDTO> getTransactionsByCategoryId(String categoryId);
    List<TransactionResponseDTO> getTransactionsByUserAndCategory(String userId, String categoryId);
    TransactionResponseDTO updateTransaction(Long txnId, TransactionRequestDTO dto);
    void deleteTransaction(Long txnId);
}
