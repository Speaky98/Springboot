package com.example.demo.tn.esprit.spring.service;

import com.example.demo.Entities.Facture;

import java.util.List;

public interface FactureService {
    List<Facture> retrieveAllFactures();
    List<Facture> getFacturesByClient(Long idClient);
    Facture addFacture(Facture f, Long idClient);
    Facture cancelFacture(Long id);
    Facture retrieveFacture(Long id);
}
