package com.kadubezas.kadubezas_bank.application.resource;

import com.kadubezas.kadubezas_bank.application.resource.dto.AccountDTO;
import com.kadubezas.kadubezas_bank.application.resource.dto.TransactionLogDTO;
import com.kadubezas.kadubezas_bank.application.resource.form.DepositForm;
import com.kadubezas.kadubezas_bank.domain.entities.Account;
import com.kadubezas.kadubezas_bank.domain.entities.TransactionLog;
import com.kadubezas.kadubezas_bank.infrastructure.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountResource {

    @Autowired
    private AccountService accountService;

    @GetMapping("/{id}")
    public ResponseEntity<AccountDTO> getAccount(@PathVariable Long id) {
        Account account = accountService.findById(id);

        if (account == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(AccountDTO.converter(account));
    }

    @PostMapping("/deposit")
    public ResponseEntity<TransactionLogDTO> deposit(@RequestBody DepositForm form) {
        TransactionLog transactionLog = accountService.deposit(form);
        return ResponseEntity.ok(TransactionLogDTO.converter(transactionLog));
    }
}
