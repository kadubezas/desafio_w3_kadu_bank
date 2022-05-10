package com.kadubezas.kadubezas_bank.infrastructure.repository;

import com.kadubezas.kadubezas_bank.domain.entities.TransactionLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionLogRepository extends JpaRepository<TransactionLog, Long> {

    List<TransactionLog> findByAccountId(Long accountId);
}
