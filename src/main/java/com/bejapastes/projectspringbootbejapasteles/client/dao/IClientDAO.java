package com.bejapastes.projectspringbootbejapasteles.client.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bejapastes.projectspringbootbejapasteles.client.modelentity.Client;

public interface IClientDAO extends JpaRepository<Client, Long> {
}
