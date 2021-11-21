package com.example.demo.tn.esprit.spring.repository;

import com.example.demo.Entities.DetailProduit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailProduitRepository extends CrudRepository<DetailProduit,Long> {
}
