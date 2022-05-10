package com.kadubezas.kadubezas_bank.application.resource.form;

public class DepositForm {

    private Double amount;
    private Long accountNumber;
    private Long agencyNumber;
    private String cpf;

    public DepositForm() {
    }

    public DepositForm(Double amount, Long accountNumber, String cpf, Long agencyNumber) {
        this.amount = amount;
        this.accountNumber = accountNumber;
        this.agencyNumber = agencyNumber;
        this.cpf = cpf;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Long getAgencyNumber() {
        return agencyNumber;
    }

    public void setAgencyNumber(Long agencyNumber) {
        this.agencyNumber = agencyNumber;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
