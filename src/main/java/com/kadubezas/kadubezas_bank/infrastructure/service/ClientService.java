package com.kadubezas.kadubezas_bank.infrastructure.service;

import com.kadubezas.kadubezas_bank.domain.entities.Client;
import com.kadubezas.kadubezas_bank.infrastructure.repository.ClientRepository;
import com.kadubezas.kadubezas_bank.infrastructure.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public Client findById(Long id) {
        Optional<Client> client = clientRepository.findById(id);

        return client.orElseThrow((() -> new ResourceNotFoundException("Client not found")));
    }
}
