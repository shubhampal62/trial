package com.natwest.costcontrol.service.impl;

import com.natwest.costcontrol.dto.BankAccountRequestDTO;
import com.natwest.costcontrol.dto.BankAccountResponseDTO;
import com.natwest.costcontrol.model.BankAccount;
import com.natwest.costcontrol.repository.BankAccountRepository;
import com.natwest.costcontrol.service.BankAccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BankAccountServiceImpl implements BankAccountService {

    private final BankAccountRepository repository;

    public BankAccountServiceImpl(BankAccountRepository repository) {
        this.repository = repository;
    }

    private BankAccountResponseDTO mapToResponse(BankAccount entity) {
        BankAccountResponseDTO dto = new BankAccountResponseDTO();
        dto.setAccountId(entity.getAccountId());
        dto.setUserId(entity.getUserId());
        dto.setAccountNumber(entity.getAccountNumber());
        dto.setAccountType(entity.getAccountType());
        dto.setBalance(entity.getBalance());
        dto.setBankName(entity.getBankName());
        dto.setIfsc(entity.getIfsc());
        dto.setAccountName(entity.getAccountName());
        return dto;
    }

    private BankAccount mapToEntity(BankAccountRequestDTO dto) {
        BankAccount entity = new BankAccount();
        entity.setUserId(dto.getUserId());
        entity.setAccountNumber(dto.getAccountNumber());
        entity.setAccountType(dto.getAccountType());
        entity.setBalance(dto.getBalance());
        entity.setBankName(dto.getBankName());
        entity.setIfsc(dto.getIfsc());
        entity.setAccountName(dto.getAccountName());
        return entity;
    }

    @Override
    public BankAccountResponseDTO createBankAccount(BankAccountRequestDTO dto) {
        BankAccount account = repository.save(mapToEntity(dto));
        return mapToResponse(account);
    }

    @Override
    public List<BankAccountResponseDTO> getAllAccounts() {
        return repository.findAll().stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    @Override
    public BankAccountResponseDTO getAccountById(Long id) {
        return repository.findById(id).map(this::mapToResponse).orElse(null);
    }

    @Override
    public List<BankAccountResponseDTO> getAccountsByUserId(Long userId) {
        return repository.findByUserId(userId).stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    @Override
    public BankAccountResponseDTO updateAccount(Long id, BankAccountRequestDTO dto) {
        return repository.findById(id).map(account -> {
            account.setAccountNumber(dto.getAccountNumber());
            account.setAccountType(dto.getAccountType());
            account.setBalance(dto.getBalance());
            account.setBankName(dto.getBankName());
            account.setIfsc(dto.getIfsc());
            account.setAccountName(dto.getAccountName());
            return mapToResponse(repository.save(account));
        }).orElse(null);
    }

    @Override
    public void deleteAccount(Long id) {
        repository.deleteById(id);
    }
}
