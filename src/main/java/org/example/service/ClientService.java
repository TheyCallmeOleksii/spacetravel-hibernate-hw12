package org.example.service;

import org.example.entity.Client;

public interface ClientService {
    void createClient(Client client);
    Client getClientById(Long id);
    void updateClient(Client client);
    void deleteClient(Client client);
}