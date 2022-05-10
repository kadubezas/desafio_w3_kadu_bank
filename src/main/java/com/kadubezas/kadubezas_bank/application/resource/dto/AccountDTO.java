package com.kadubezas.kadubezas_bank.application.resource.dto;

import com.kadubezas.kadubezas_bank.domain.entities.Account;

public class AccountDTO {

    private Long id;
    private Double balance;
    private String client;
    private String agency;

    public AccountDTO() {
    }

    public AccountDTO(Long id, Double balance, String client, String agency) {
        this.id = id;
        this.balance = balance;
        this.client = client;
        this.agency = agency;
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

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public static AccountDTO converter(Account account) {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setId(account.getId());
        accountDTO.setBalance(account.getBalance());
        accountDTO.setClient(account.getClient().getName());
        accountDTO.setAgency(account.getAgency().getName());

        return accountDTO;
    }
}
