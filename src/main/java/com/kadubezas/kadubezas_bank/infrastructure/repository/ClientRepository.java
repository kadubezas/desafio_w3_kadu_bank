package com.kadubezas.kadubezas_bank.infrastructure.repository;

import com.kadubezas.kadubezas_bank.domain.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
