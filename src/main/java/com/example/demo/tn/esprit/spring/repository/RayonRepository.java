package com.example.demo.tn.esprit.spring.repository;

import com.example.demo.Entities.Rayon;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RayonRepository extends CrudRepository<Rayon,Long> {
}
