package org.example.dao;

import org.example.entity.Client;

public interface ClientDaoService {
    void create(Client client);
    Client getById(Long id);
    void update(Client client);
    void delete(Client client);
}