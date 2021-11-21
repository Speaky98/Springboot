package com.example.demo.tn.esprit.spring.repository;

import com.example.demo.Entities.Fournisseur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FournisseurRepository extends CrudRepository<Fournisseur,Long> {
}
