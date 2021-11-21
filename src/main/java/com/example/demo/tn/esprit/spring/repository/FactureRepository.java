package com.example.demo.tn.esprit.spring.repository;

import com.example.demo.Entities.Facture;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactureRepository extends CrudRepository<Facture,Long> {
}
