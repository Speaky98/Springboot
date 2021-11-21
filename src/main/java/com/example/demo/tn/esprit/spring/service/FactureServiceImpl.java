package com.example.demo.tn.esprit.spring.service;

import com.example.demo.Entities.Client;
import com.example.demo.Entities.Facture;
import com.example.demo.Entities.Produit;
import com.example.demo.tn.esprit.spring.repository.ClientRepository;
import com.example.demo.tn.esprit.spring.repository.FactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FactureServiceImpl implements FactureService {
    @Autowired
    FactureRepository factureRepository;
    @Autowired
    ClientRepository clientRepository;
    @Override
    public List<Facture> retrieveAllFactures() {
        return (List<Facture>) this.factureRepository.findAll();
    }

    @Override
    public List<Facture> getFacturesByClient(Long idClient) {
        Client client=this.clientRepository.findById(idClient).get();
        return client.getSet_Factures().stream().collect(Collectors.toList());
    }

    @Override
    public Facture addFacture(Facture f, Long idClient) {
        Facture facture=new Facture();
        if(f.getIdFacture()!=0 && idClient!=null) {
            if(this.clientRepository.findById(idClient).isPresent() &&
                    this.factureRepository.findById(f.getIdFacture()).isPresent()) {
                facture = this.factureRepository.findById(f.getIdFacture()).get();
                facture.setClients(this.clientRepository.findById(idClient).get());
                this.factureRepository.save(facture);}}
        return facture;
    }

    @Override
    public Facture cancelFacture(Long id) {
        Facture facture=this.factureRepository.findById(id).get();
        facture.setActive(false);
       return this.factureRepository.save(facture);

    }

    @Override
    public Facture retrieveFacture(Long id) {
        return this.factureRepository.findById(id).get();
    }
}
