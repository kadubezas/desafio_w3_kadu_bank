package com.kadubezas.kadubezas_bank.application.resource.dto;

import com.kadubezas.kadubezas_bank.domain.entities.Client;

import java.util.List;

public class ClientDTO {

    private Long id;
    private String name;
    private String cpf;

    public ClientDTO() {
    }

    public ClientDTO(Client client) {
        this.id = client.getId();
        this.name = client.getName();
        this.cpf = client.getCpf();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public static List<ClientDTO> convert(List<Client> clients) {
       return clients.stream().map(ClientDTO::new).collect(java.util.stream.Collectors.toList());
    }

    public static ClientDTO convert(Client client) {
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setId(client.getId());
        clientDTO.setName(client.getName());
        clientDTO.setCpf(client.getCpf());
        return clientDTO;
    }
}
