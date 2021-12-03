package com.example.demo.tn.esprit.spring.service;

import com.example.demo.Entities.Fournisseur;
import com.example.demo.Entities.Produit;
import com.example.demo.Entities.Rayon;
import com.example.demo.tn.esprit.spring.repository.ProduitRepository;
import com.example.demo.tn.esprit.spring.repository.RayonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
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

    @Scheduled(cron = "*/5 * * * * *")
    public void reset_value(){
        List<Rayon> check_list= (List<Rayon>) this.rayonRepository.findAll();
        if(check_list.size()==0)
            this.rayonRepository.reset_auto_increment();
    }
}
