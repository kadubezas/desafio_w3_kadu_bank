package com.kadubezas.kadubezas_bank.application.resource.form;

public class WithdrawForm {

    private Long accountNumber;
    private Double amount;
    private String password;

    public WithdrawForm() {

    }

    public WithdrawForm(Long accountNumber, Double amount, String password) {
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.password = password;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
