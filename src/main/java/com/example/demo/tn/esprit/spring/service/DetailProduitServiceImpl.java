package com.example.demo.tn.esprit.spring.service;

import com.example.demo.Entities.DetailProduit;
import com.example.demo.tn.esprit.spring.repository.DetailProduitRepository;
import com.example.demo.tn.esprit.spring.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetailProduitServiceImpl implements DetailProduitService{
    @Autowired
    private DetailProduitRepository detailProduitRepository;
    @Autowired
    private ProduitRepository produitRepository;
    @Override
    public DetailProduit addDetailProduit(DetailProduit dp) {
//        if(dp.getProduit()!=null)
//        dp.setProduit(this.produitRepository.findById(dp.getProduit().getIdProduit()).get());
        return this.detailProduitRepository.save(dp);
    }

    @Override
    public DetailProduit updateDetailProduit(DetailProduit dp) {
//        if(dp.getProduit()!=null)
//            dp.setProduit(this.produitRepository.findById(dp.getProduit().getIdProduit()).get());
        return this.detailProduitRepository.save(dp);
    }
}
