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

    private final TransactionRepository repository;

    public TransactionServiceImpl(TransactionRepository repository) {
        this.repository = repository;
    }

    private TransactionResponseDTO mapToDTO(Transaction t) {
        TransactionResponseDTO dto = new TransactionResponseDTO();
        dto.setTransactionId(t.getTransactionId());
        dto.setUserId(t.getUserId());
        dto.setCategoryId(t.getCategoryId());
        dto.setBudgetId(t.getBudgetId());
        dto.setAccountId(t.getAccountId());
        dto.setAmount(t.getAmount());
        dto.setTransactionDate(t.getTransactionDate());
        dto.setDescription(t.getDescription());
        dto.setMerchantName(t.getMerchantName());
        return dto;
    }

    private Transaction mapToEntity(TransactionRequestDTO request) {
        Transaction t = new Transaction();
        t.setUserId(request.getUserId());
        t.setCategoryId(request.getCategoryId());
        t.setBudgetId(request.getBudgetId());
        t.setAccountId(request.getAccountId());
        t.setAmount(request.getAmount());
        t.setTransactionDate(request.getTransactionDate());
        t.setDescription(request.getDescription());
        t.setMerchantName(request.getMerchantName());
        return t;
    }

    @Override
    public TransactionResponseDTO createTransaction(TransactionRequestDTO request) {
        Transaction t = repository.save(mapToEntity(request));
        return mapToDTO(t);
    }

    @Override
    public List<TransactionResponseDTO> getAllTransactions() {
        return repository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public TransactionResponseDTO getTransactionById(Long id) {
        return repository.findById(id).map(this::mapToDTO)
                .orElseThrow(() -> new RuntimeException("Transaction not found with id " + id));
    }

    @Override
    public List<TransactionResponseDTO> getTransactionsByUser(Long userId) {
        return repository.findByUserId(userId).stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public List<TransactionResponseDTO> getTransactionsByCategory(Long categoryId) {
        return repository.findByCategoryId(categoryId).stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public TransactionResponseDTO updateTransaction(Long id, TransactionRequestDTO request) {
        Transaction t = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found with id " + id));

        t.setUserId(request.getUserId());
        t.setCategoryId(request.getCategoryId());
        t.setBudgetId(request.getBudgetId());
        t.setAccountId(request.getAccountId());
        t.setAmount(request.getAmount());
        t.setTransactionDate(request.getTransactionDate());
        t.setDescription(request.getDescription());
        t.setMerchantName(request.getMerchantName());

        return mapToDTO(repository.save(t));
    }

    @Override
    public void deleteTransaction(Long id) {
        repository.deleteById(id);
    }
}
