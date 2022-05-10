package com.kadubezas.kadubezas_bank.application.resource;

import com.kadubezas.kadubezas_bank.application.resource.dto.ClientDTO;
import com.kadubezas.kadubezas_bank.domain.entities.Client;
import com.kadubezas.kadubezas_bank.infrastructure.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientResource {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<List<ClientDTO>> getClient() {
        List<Client> list = clientService.findAll();
        return ResponseEntity.ok(ClientDTO.convert(list));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClientDTO> getClientById(@PathVariable Long id) {
        Client client = clientService.findById(id);

        if (client == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(ClientDTO.convert(client));
    }
}
