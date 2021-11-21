package com.example.demo.tn.esprit.spring.service;

import com.example.demo.Entities.DetailProduit;
import com.example.demo.Entities.Produit;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ProduitService {
    List<Produit> retrieveAllProduits();
    Produit addProduit(Produit p, Long idRayon, Long idStock, DetailProduit detailProduit);
    Produit retrieveProduit(Long id);
    void deleteProduit(Long id);
    Produit updateProduit(Produit u, Long idRayon, Long idStock,DetailProduit detailProduit);
    void assignProduitToStock(Long idProduit, Long idStock);
    float getRevenuBrutProduit(Long idProduit, Date startDate, Date endDate);
}
