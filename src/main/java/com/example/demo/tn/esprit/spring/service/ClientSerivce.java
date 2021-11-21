package com.example.demo.tn.esprit.spring.service;

import com.example.demo.Entities.CategorieClient;
import com.example.demo.Entities.Client;

import java.util.Date;
import java.util.List;

public interface ClientSerivce {
    List<Client> retrieveAllClients();
    Client addClient(Client c);
    void deleteClient(Long id);
    Client updateClient(Client c);
    Client retrieveClient(Long id);
    float getChiffreAffaireParCategorieClient(CategorieClient categorieClient,Date startDate,Date endDate);
}
