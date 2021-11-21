package com.example.demo.tn.esprit.spring.service;

import com.example.demo.Entities.Fournisseur;
import com.example.demo.Entities.Produit;
import com.example.demo.tn.esprit.spring.repository.FournisseurRepository;
import com.example.demo.tn.esprit.spring.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FournisseurServiceImpl implements FournisseurService{

    @Autowired
    FournisseurRepository fournisseurRepository;
    @Autowired
    ProduitRepository produitRepository;


    @Override
    public List<Fournisseur> retrieveAllFournisseurs() {
        return (List<Fournisseur>) this.fournisseurRepository.findAll();
    }

    @Override
    public Fournisseur addFournisseur(Fournisseur f) {
        return this.fournisseurRepository.save(f);
    }

    @Override
    public void deleteFournisseur(Long id) {
        this.fournisseurRepository.deleteById(id);
    }

    @Override
    public Fournisseur updateFournisseur(Fournisseur f) {
        return this.fournisseurRepository.save(f);
    }

    @Override
    public Fournisseur retrieveFournisseur(Long id) {
        return this.fournisseurRepository.findById(id).get();
    }

    @Override
    public void assignFournisseurToProduit(Long fournisseurId, Long produitId) {
        if (fournisseurId != null && produitId != null) {
            if (this.produitRepository.findById(produitId).isPresent()
                    && this.fournisseurRepository.findById(fournisseurId).isPresent()) {
                Produit u = this.produitRepository.findById(produitId).get();
                u.getFournisseurs().add(this.fournisseurRepository.findById(fournisseurId).get());
                this.produitRepository.save(u);
            }
        }
    }
}
