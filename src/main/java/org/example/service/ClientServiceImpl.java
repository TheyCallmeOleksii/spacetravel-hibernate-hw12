package org.example.service;

import org.example.dao.ClientDaoService;
import org.example.entity.Client;

public class ClientServiceImpl implements ClientService {

    private final ClientDaoService clientDao;

    public ClientServiceImpl(ClientDaoService clientDao) {
        this.clientDao = clientDao;
    }

    @Override
    public void createClient(Client client) {
        validateClient(client);
        clientDao.create(client);
    }

    @Override
    public Client getClientById(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID клієнта не може бути порожнім або від'ємним");
        }
        return clientDao.getById(id);
    }

    @Override
    public void updateClient(Client client) {
        validateClient(client);
        if (client.getId() == null) {
            throw new IllegalArgumentException("Неможливо оновити клієнта без ID");
        }
        clientDao.update(client);
    }

    @Override
    public void deleteClient(Client client) {
        if (client == null || client.getId() == null) {
            throw new IllegalArgumentException("Клієнт або його ID не можуть бути null");
        }
        clientDao.delete(client);
    }

    private void validateClient(Client client) {
        if (client == null || client.getName() == null) {
            throw new IllegalArgumentException("Клієнт або його ім'я не можуть бути порожніми");
        }
        int nameLength = client.getName().length();
        if (nameLength < 3 || nameLength > 200) {
            throw new IllegalArgumentException("Ім'я клієнта має містити від 3 до 200 символів");
        }
    }
}