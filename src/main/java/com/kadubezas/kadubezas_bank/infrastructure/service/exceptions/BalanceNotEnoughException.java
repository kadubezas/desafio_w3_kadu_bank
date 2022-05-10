package com.kadubezas.kadubezas_bank.infrastructure.service.exceptions;

public class BalanceNotEnoughException extends RuntimeException {
    public BalanceNotEnoughException(String message) {
        super(message);
    }
}
