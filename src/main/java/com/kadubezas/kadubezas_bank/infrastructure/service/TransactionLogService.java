package com.kadubezas.kadubezas_bank.infrastructure.service;

import com.kadubezas.kadubezas_bank.domain.entities.TransactionLog;
import com.kadubezas.kadubezas_bank.infrastructure.repository.TransactionLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionLogService {

    @Autowired
    private TransactionLogRepository transactionLogRepository;

    public List<TransactionLog> findByAccountId(Long accountId) {
        Optional<List<TransactionLog>> transactionLogs = Optional.ofNullable(transactionLogRepository.findByAccountId(accountId));

        return transactionLogs.orElse(null);
    }

    public TransactionLog insert(TransactionLog transactionLog) {
        return transactionLogRepository.save(transactionLog);
    }
}
