package com.example.demo;

import com.example.demo.Entities.Produit;
import com.example.demo.Entities.Rayon;
import com.example.demo.tn.esprit.spring.repository.ProduitRepository;
import com.example.demo.tn.esprit.spring.service.ProduitService;
import com.example.demo.tn.esprit.spring.service.RayonService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;

@Slf4j
@SpringBootTest
public class RayonTests {
    @Autowired
    private RayonService rayonService;
    @Autowired
    private ProduitService produitService;
    @Autowired
    private ProduitRepository produitRepository;

    @Test
    void AddRayon() {
        Rayon rayon_1=new Rayon();
        rayon_1.setIdRayon(7);
        rayon_1.setCode("9603");
        rayon_1.setLibelle("Informatique");
        rayonService.addRayon(rayon_1);
    }
   @Transactional
    @Test
    void DisplayRayons() {
        for (Rayon r:
                this.rayonService.retrieveAllRayons()) {
            r.getSet_r_produits().forEach(produit -> {
                log.info(produit.toString());
            });
        }
    }
    @Test
    void DeleteRayon() {
        this.rayonService.retrieveAllRayons().forEach(rayon -> {
            rayon.getSet_r_produits().forEach(produit -> {
                if(rayon.getIdRayon()==1) {
                    produit.setRayons(null);
                    produitRepository.save(produit);
                }
            });
        });
        rayonService.deleteRayon(1L);

    }
}
