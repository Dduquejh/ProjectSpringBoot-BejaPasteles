package com.bejapastes.projectspringbootbejapasteles.client.services;

import com.bejapastes.projectspringbootbejapasteles.client.modelentity.Client;
import java.util.List;

public interface IClientService {
    public List<Client> findAll();
    public Client save(Client client);
    public Client findById(Long id);
    public void deleteById(Long id);
}
