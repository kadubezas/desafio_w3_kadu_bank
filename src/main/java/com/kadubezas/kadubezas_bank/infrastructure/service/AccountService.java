package com.kadubezas.kadubezas_bank.infrastructure.service;

import com.kadubezas.kadubezas_bank.application.resource.form.DepositForm;
import com.kadubezas.kadubezas_bank.application.resource.form.WithdrawForm;
import com.kadubezas.kadubezas_bank.domain.entities.Account;
import com.kadubezas.kadubezas_bank.domain.entities.Agency;
import com.kadubezas.kadubezas_bank.domain.entities.TransactionLog;
import com.kadubezas.kadubezas_bank.domain.entities.enums.TransactionType;
import com.kadubezas.kadubezas_bank.infrastructure.repository.AccountRepository;
import com.kadubezas.kadubezas_bank.infrastructure.service.exceptions.BalanceNotEnoughException;
import com.kadubezas.kadubezas_bank.infrastructure.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AgencyService agencyService;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionLogService transactionLogService;

    public Account findById(Long id) {
        Optional<Account> account = accountRepository.findById(id);

        return account.orElseThrow(() -> new ResourceNotFoundException("Account "+id+" not found"));
    }

    public void insert(Account account) {
        accountRepository.save(account);
    }

    public TransactionLog deposit(DepositForm depositForm) {
        Agency agency = agencyService.findById(depositForm.getAgencyNumber());

        if(agency == null) {
            throw new ResourceNotFoundException("Agency "+depositForm.getAgencyNumber()+" not found");
        }

        Account account = findById(depositForm.getAccountNumber());

        if(!agency.getAccounts().contains(account)) {
            throw new ResourceNotFoundException("Account "+depositForm.getAccountNumber()+" not found");
        }

        if(!account.getClient().getCpf().equals(depositForm.getCpf())) {
            throw new ResourceNotFoundException("Account CPF "+depositForm.getCpf()+" not corresponds to the account "+depositForm.getAccountNumber());
        }

        account.deposit(depositForm.getAmount());

        accountRepository.save(account);

        TransactionLog transactionLog = new TransactionLog(Instant.now(),depositForm.getAmount(), TransactionType.DEPOSIT ,account);

        return transactionLogService.insert(transactionLog);
    }

    public TransactionLog withdraw(WithdrawForm form) {
        Account account = findById(form.getAccountNumber());

        if(account.getBalance() < form.getAmount()) {
            throw new BalanceNotEnoughException("Account "+form.getAccountNumber()+": Insufficient balance");
        }

        account.withdraw(form.getAmount());

        return transactionLogService.insert(new TransactionLog(Instant.now(),form.getAmount(), TransactionType.WITHDRAW ,account));
    }
}
