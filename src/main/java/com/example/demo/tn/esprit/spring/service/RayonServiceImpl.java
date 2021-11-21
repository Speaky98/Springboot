package com.example.demo.tn.esprit.spring.service;

import com.example.demo.Entities.Produit;
import com.example.demo.Entities.Rayon;
import com.example.demo.tn.esprit.spring.repository.ProduitRepository;
import com.example.demo.tn.esprit.spring.repository.RayonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class RayonServiceImpl implements RayonService{
    @Autowired
    RayonRepository rayonRepository;
    @Autowired
    ProduitRepository produitRepository;
    @Override
    public List<Rayon> retrieveAllRayons() {
      return (List<Rayon>) this.rayonRepository.findAll();
    }

    @Override
    public Rayon addRayon(Rayon r) {
        r.getSet_r_produits().add(this.produitRepository.findById(1L).get());
        r.setIdRayon(r.getIdRayon());
        r.setCode(r.getCode());
        r.setLibelle(r.getLibelle());

        return this.rayonRepository.save(r);
    }

    @Override
    public void deleteRayon(Long id) {
        this.rayonRepository.deleteById(id);
    }

    @Override
    public Rayon updateRayon(Rayon r) {
       /* r.getSet_r_produits().add(this.produitRepository.findById(3L).get());
        r.setIdRayon(r.getIdRayon());
        r.setCode(r.getCode());
        r.setLibelle(r.getLibelle());*/

        return this.rayonRepository.save(r);
    }

    @Override
    public Rayon retrieveRayon(Long id) {
        return this.rayonRepository.findById(id).get();
    }
}
