package com.example.demo.tn.esprit.spring.service;

import com.example.demo.Entities.CategorieClient;
import com.example.demo.Entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.tn.esprit.spring.repository.ClientRepository;

import java.util.Date;
import java.util.List;
@Service
public class ClientServiceImpl implements ClientSerivce{
    @Autowired
    private ClientRepository clientRepository;
    @Override
    public List<Client> retrieveAllClients() {
        return (List<Client>) this.clientRepository.findAll();
    }

    @Override
    public Client addClient(Client c) {
        return this.clientRepository.save(c);
    }

    @Override
    public void deleteClient(Long id) {
    if(id!=0)
        this.clientRepository.deleteById(id);
    }

    @Override
    public Client updateClient(Client c) {
        /*Client client_1=this.clientRepository.findById(c.getIdClient()).get();
        client_1.setPrenom(c.getPrenom());
        client_1.setNom(c.getNom());
        client_1.setEmail(c.getEmail());
        client_1.setDateNaissance(c.getDateNaissance());
        client_1.setCategorieClient(c.getCategorieClient());
        */
        /**
         zid b9eyet setter
         **/
        return this.clientRepository.save(c);
    }

    @Override
    public Client retrieveClient(Long id) {
        return this.clientRepository.findById(id).get();
    }

    @Override
    public float getChiffreAffaireParCategorieClient(CategorieClient categorieClient, Date startDate, Date endDate) {
        return this.clientRepository.getChiffreAffaireParCategorieClient(categorieClient,startDate,endDate);
    }
}
