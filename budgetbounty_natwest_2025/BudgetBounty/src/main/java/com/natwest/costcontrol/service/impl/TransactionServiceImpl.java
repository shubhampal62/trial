package com.natwest.costcontrol.service.impl;

import com.natwest.costcontrol.dto.TransactionRequestDTO;
import com.natwest.costcontrol.dto.TransactionResponseDTO;
import com.natwest.costcontrol.model.Transaction;
import com.natwest.costcontrol.repository.TransactionRepository;
import com.natwest.costcontrol.service.TransactionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    private TransactionResponseDTO mapToResponse(Transaction transaction) {
        TransactionResponseDTO dto = new TransactionResponseDTO();
        dto.setTxnId(transaction.getTxnId());
        dto.setUserId(transaction.getUserId());
        dto.setCategoryId(transaction.getCategoryId());
        dto.setBudgetId(transaction.getBudgetId());
        dto.setAccountId(transaction.getAccountId());
        dto.setUpiRefId(transaction.getUpiRefId());
        dto.setRecipientId(transaction.getRecipientId());
        dto.setAmount(transaction.getAmount());
        dto.setTxnType(transaction.getTxnType());
        dto.setTxnStatus(transaction.getTxnStatus());
        dto.setTxnDate(transaction.getTxnDate());
        dto.setTxnChannel(transaction.getTxnChannel());
        dto.setRewardsEarned(transaction.getRewardsEarned());
        dto.setMerchantName(transaction.getMerchantName());
        dto.setDescription(transaction.getDescription());
        return dto;
    }

    private Transaction mapToEntity(TransactionRequestDTO dto) {
        Transaction transaction = new Transaction();
        transaction.setUserId(dto.getUserId());
        transaction.setCategoryId(dto.getCategoryId());
        transaction.setBudgetId(dto.getBudgetId());
        transaction.setAccountId(dto.getAccountId());
        transaction.setUpiRefId(dto.getUpiRefId());
        transaction.setRecipientId(dto.getRecipientId());
        transaction.setAmount(dto.getAmount());
        transaction.setTxnType(dto.getTxnType());
        transaction.setTxnStatus(dto.getTxnStatus());
        transaction.setTxnDate(dto.getTxnDate());
        transaction.setTxnChannel(dto.getTxnChannel());
        transaction.setRewardsEarned(dto.getRewardsEarned());
        transaction.setMerchantName(dto.getMerchantName());
        transaction.setDescription(dto.getDescription());
        return transaction;
    }

    @Override
    public TransactionResponseDTO createTransaction(TransactionRequestDTO dto) {
        Transaction transaction = mapToEntity(dto);
        return mapToResponse(transactionRepository.save(transaction));
    }

    @Override
    public TransactionResponseDTO getTransactionById(Long txnId) {
        return transactionRepository.findById(txnId)
                .map(this::mapToResponse)
                .orElse(null);
    }

    @Override
    public List<TransactionResponseDTO> getAllTransactions() {
        return transactionRepository.findAll()
                .stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    @Override
    public List<TransactionResponseDTO> getTransactionsByUserId(String userId) {
        return transactionRepository.findByUserId(userId)
                .stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    @Override
    public List<TransactionResponseDTO> getTransactionsByCategoryId(String categoryId) {
        return transactionRepository.findByCategoryId(categoryId)
                .stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    @Override
    public List<TransactionResponseDTO> getTransactionsByUserAndCategory(String userId, String categoryId) {
        return transactionRepository.findByUserIdAndCategoryId(userId, categoryId)
                .stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    @Override
    public TransactionResponseDTO updateTransaction(Long txnId, TransactionRequestDTO dto) {
        return transactionRepository.findById(txnId).map(existing -> {
            existing.setUserId(dto.getUserId());
            existing.setCategoryId(dto.getCategoryId());
            existing.setBudgetId(dto.getBudgetId());
            existing.setAccountId(dto.getAccountId());
            existing.setUpiRefId(dto.getUpiRefId());
            existing.setRecipientId(dto.getRecipientId());
            existing.setAmount(dto.getAmount());
            existing.setTxnType(dto.getTxnType());
            existing.setTxnStatus(dto.getTxnStatus());
            existing.setTxnDate(dto.getTxnDate());
            existing.setTxnChannel(dto.getTxnChannel());
            existing.setRewardsEarned(dto.getRewardsEarned());
            existing.setMerchantName(dto.getMerchantName());
            existing.setDescription(dto.getDescription());
            return mapToResponse(transactionRepository.save(existing));
        }).orElse(null);
    }

    @Override
    public void deleteTransaction(Long txnId) {
        transactionRepository.deleteById(txnId);
    }
}
