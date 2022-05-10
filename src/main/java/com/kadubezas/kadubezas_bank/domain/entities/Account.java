package com.kadubezas.kadubezas_bank.domain.entities;

import com.kadubezas.kadubezas_bank.infrastructure.service.exceptions.BalanceNotEnoughException;
import com.kadubezas.kadubezas_bank.infrastructure.service.exceptions.ResourceNotFoundException;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_account")
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double balance;

    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "agency_id")
    private Agency agency;

    @OneToMany(mappedBy = "account")
    private List<TransactionLog> transactionLogs = new ArrayList<>();

    public Account() {
    }

    public Account(Double balance, Client client, Agency agency) {
        this.balance = balance;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Agency getAgency() {
        return agency;
    }

    public List<TransactionLog> getTransactionLogs() {
        return transactionLogs;
    }

    public void deposit(Double amount) {
        this.balance += amount;
    }

    public void withdraw(Double amount) {
            this.balance -= amount;
    }
}
