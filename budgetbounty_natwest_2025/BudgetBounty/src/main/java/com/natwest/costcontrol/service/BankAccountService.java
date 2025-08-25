package com.natwest.costcontrol.service;

import com.natwest.costcontrol.dto.BankAccountRequestDTO;
import com.natwest.costcontrol.dto.BankAccountResponseDTO;
import java.util.List;

public interface BankAccountService {
    BankAccountResponseDTO createBankAccount(BankAccountRequestDTO dto);
    List<BankAccountResponseDTO> getAllAccounts();
    BankAccountResponseDTO getAccountById(Long id);
    List<BankAccountResponseDTO> getAccountsByUserId(Long userId);
    BankAccountResponseDTO updateAccount(Long id, BankAccountRequestDTO dto);
    void deleteAccount(Long id);
}
