package com.kadubezas.kadubezas_bank.infrastructure.repository;

import com.kadubezas.kadubezas_bank.domain.entities.Agency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgencyRepository extends JpaRepository<Agency, Long> {
}
