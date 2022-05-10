package com.kadubezas.kadubezas_bank.application.resource.dto;

import com.kadubezas.kadubezas_bank.domain.entities.TransactionLog;

import java.time.Instant;
import java.util.List;

public class TransactionLogDTO {

    private Long id;
    private Instant date;
    private Double value;
    private String type;

    public TransactionLogDTO() {
    }

    public TransactionLogDTO(Long id, Instant date, Double value, String type) {
        this.id = id;
        this.date = date;
        this.value = value;
        this.type = type;
    }

    public TransactionLogDTO(TransactionLog transactionLog) {
        this.id = transactionLog.getId();
        this.date = transactionLog.getDate();
        this.value = transactionLog.getValue();
        this.type = transactionLog.getType().name();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static List<TransactionLogDTO> converter(List<TransactionLog> transactionLog) {
        return transactionLog.stream().map(TransactionLogDTO::new).collect(java.util.stream.Collectors.toList());
    }

    public static TransactionLogDTO converter(TransactionLog transactionLog) {
        return new TransactionLogDTO(transactionLog);
    }
}
