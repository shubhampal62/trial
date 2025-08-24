package com.natwest.costcontrol.controller;

import com.natwest.costcontrol.dto.BankAccountRequestDTO;
import com.natwest.costcontrol.dto.BankAccountResponseDTO;
import com.natwest.costcontrol.service.BankAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bank-accounts")
public class BankAccountController {

    private final BankAccountService service;

    public BankAccountController(BankAccountService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<BankAccountResponseDTO> create(@RequestBody BankAccountRequestDTO dto) {
        return ResponseEntity.ok(service.createBankAccount(dto));
    }

    @GetMapping
    public ResponseEntity<List<BankAccountResponseDTO>> getAll() {
        return ResponseEntity.ok(service.getAllAccounts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BankAccountResponseDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getAccountById(id));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<BankAccountResponseDTO>> getByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(service.getAccountsByUserId(userId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BankAccountResponseDTO> update(@PathVariable Long id, @RequestBody BankAccountRequestDTO dto) {
        return ResponseEntity.ok(service.updateAccount(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteAccount(id);
        return ResponseEntity.noContent().build();
    }
}
