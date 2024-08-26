package com.bejapastes.projectspringbootbejapasteles.client.services;

import com.bejapastes.projectspringbootbejapasteles.client.modelentity.Client;
import com.bejapastes.projectspringbootbejapasteles.client.dao.IClientDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClientService implements IClientService {
    @Autowired
    private IClientDAO clientDAO;

    @Override
    public List<Client> findAll() {
        return clientDAO.findAll();
    }

    @Override
    public Client save(Client client) {
        return clientDAO.save(client);
    }

    @Override
    public Client findById(Long id) {
        return clientDAO.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        clientDAO.deleteById(id);
    }
}
