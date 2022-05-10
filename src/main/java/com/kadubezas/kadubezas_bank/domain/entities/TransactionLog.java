package com.kadubezas.kadubezas_bank.domain.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kadubezas.kadubezas_bank.domain.entities.enums.TransactionType;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "tb_transaction_log")
public class TransactionLog implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant date;
    private Double value;
    private Integer type;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    public TransactionLog() {
    }

    public TransactionLog(Instant date, Double value, TransactionType type, Account account) {
        this.date = date;
        this.value = value;
        this.account = account;
        setType(type);
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

    public TransactionType getType() {
        return TransactionType.valueOf(type);
    }

    public void setType(TransactionType type) {
        if (type != null) {
            this.type = type.getCode();
        }
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
