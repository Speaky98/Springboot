package com.example.demo;

import com.example.demo.Entities.Produit;
import com.example.demo.tn.esprit.spring.repository.ProduitRepository;
import com.example.demo.tn.esprit.spring.service.ProduitService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@Slf4j
@SpringBootTest
public class ProduitTests {
    @Autowired
    private ProduitService produitService;
    @Autowired
    private ProduitRepository produitRepository;
    @Test
    void AddProduit() {
        Produit produit_1=new Produit();
        produit_1.setIdProduit(1);produit_1.setCode("00064");produit_1.setLibelle("Lait");
        produit_1.setPrixUnitaire(1.27f);
        this.produitService.addProduit(produit_1,1L,2L,null);
    }
    @Test
    void DisplayProduit() {
        log.info(this.produitService.retrieveProduit(1L).toString());
    }
    @Test
    void DisplayProduits() {
        for (Produit p:
                this.produitService.retrieveAllProduits()) {
            log.info(p.toString());
        }
    }
    @Test
    void RevenuBrut() {
        System.out.println(this.produitRepository.getRevenuBrutProduit(1L,new Date("1997/01/01"),new Date("1997/09/01")));
    }
    @Test
    void DeleteProduit() {}


}
