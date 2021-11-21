package com.example.demo.tn.esprit.spring.service;

import com.example.demo.Entities.Fournisseur;

import java.util.List;

public interface FournisseurService {
    List<Fournisseur> retrieveAllFournisseurs();
    Fournisseur addFournisseur(Fournisseur f);
    void deleteFournisseur(Long id);
    Fournisseur updateFournisseur(Fournisseur f);
    Fournisseur retrieveFournisseur(Long id);
    void assignFournisseurToProduit(Long fournisseurId, Long produitId);

}
