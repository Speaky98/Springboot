package com.example.demo.tn.esprit.spring.repository;

import com.example.demo.Entities.Stock;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends CrudRepository<Stock,Long> {
}
