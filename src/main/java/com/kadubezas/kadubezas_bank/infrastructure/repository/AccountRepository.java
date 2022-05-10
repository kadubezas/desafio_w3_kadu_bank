package com.kadubezas.kadubezas_bank.infrastructure.repository;

import com.kadubezas.kadubezas_bank.domain.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
