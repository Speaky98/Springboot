package com.example.demo.tn.esprit.spring.repository;

import com.example.demo.Entities.detailFacture;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface detailFactureRepository extends CrudRepository<detailFacture,Long> {
}
