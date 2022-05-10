package com.kadubezas.kadubezas_bank.application.resource;

import com.kadubezas.kadubezas_bank.application.resource.dto.TransactionLogDTO;
import com.kadubezas.kadubezas_bank.domain.entities.TransactionLog;
import com.kadubezas.kadubezas_bank.infrastructure.service.TransactionLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Extract")
public class TransactionLogResource {

    @Autowired
    private TransactionLogService transactionLogService;

    @GetMapping("/{id}")
    public ResponseEntity<List<TransactionLogDTO>> findById(@PathVariable Long id) {
        List<TransactionLog> transactionLogs = transactionLogService.findByAccountId(id);

        if(transactionLogs.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(TransactionLogDTO.converter(transactionLogs));
    }
}
