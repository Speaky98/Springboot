package com.example.demo.tn.esprit.spring.service;

import com.example.demo.Entities.DetailProduit;
import com.example.demo.Entities.Produit;
import com.example.demo.tn.esprit.spring.repository.ProduitRepository;
import com.example.demo.tn.esprit.spring.repository.RayonRepository;
import com.example.demo.tn.esprit.spring.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProduitServiceImpl implements ProduitService{
    @Autowired
    ProduitRepository produitRepository;

    @Autowired
    StockRepository stockRepository;

    @Autowired
    RayonRepository rayonRepository;

    @Autowired
    DetailProduitService detailProduitService;


    @Override
    public List<Produit> retrieveAllProduits() {
        return (List<Produit>) this.produitRepository.findAll();
    }

    @Override
    public Produit addProduit(Produit p, Long idRayon, Long idStock, DetailProduit detailProduit) {
        if(idStock!=null)
        p.setStocks(this.stockRepository.findById(idStock).get());
        if(idRayon!=null)
        p.setRayons(this.rayonRepository.findById(idRayon).get());
       this.produitRepository.save(p);
       detailProduit.setProduit(p);
        this.detailProduitService.addDetailProduit(detailProduit);
        return p;
    }

    @Override
    public Produit retrieveProduit(Long id) {
        return this.produitRepository.findById(id).get();
    }

    @Override
    public void deleteProduit(Long id) {
        this.produitRepository.deleteById(id);

    }

    @Override
    public Produit updateProduit(Produit u, Long idRayon, Long idStock,DetailProduit detailProduit) {
        if(idStock!=null) u.setStocks(this.stockRepository.findById(idStock).get());
        if(idRayon!=null) u.setRayons(this.rayonRepository.findById(idRayon).get());
        this.produitRepository.save(u);
        detailProduit.setProduit(u);
        this.detailProduitService.updateDetailProduit(detailProduit);
        return u;
    }

    @Override
    public void assignProduitToStock(Long idProduit, Long idStock) {
        if(idStock!=null && idProduit!=null) {
            if(this.produitRepository.findById(idProduit).isPresent() && this.stockRepository.findById(idStock).isPresent()) {
               Produit u = this.produitRepository.findById(idProduit).get();
                u.setStocks(this.stockRepository.findById(idStock).get());
                this.produitRepository.save(u);
            }
        }
    }

    @Override
    public float getRevenuBrutProduit(Long idProduit, Date startDate, Date endDate) {
        return this.produitRepository.getRevenuBrutProduit(idProduit,startDate,endDate);
    }
}
