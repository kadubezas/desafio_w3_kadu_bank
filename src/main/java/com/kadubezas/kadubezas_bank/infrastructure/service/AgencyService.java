package com.kadubezas.kadubezas_bank.infrastructure.service;

import com.kadubezas.kadubezas_bank.domain.entities.Agency;
import com.kadubezas.kadubezas_bank.infrastructure.repository.AgencyRepository;
import com.kadubezas.kadubezas_bank.infrastructure.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AgencyService{

    @Autowired
    private AgencyRepository agencyRepository;

    public Agency findById(Long id){
        Optional<Agency> agency = agencyRepository.findById(id);

        return agency.orElseThrow(() -> new ResourceNotFoundException("Agency "+id+" not found"));
    }
}
