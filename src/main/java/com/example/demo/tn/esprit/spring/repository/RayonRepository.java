package com.example.demo.tn.esprit.spring.repository;

import com.example.demo.Entities.Rayon;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface RayonRepository extends CrudRepository<Rayon,Long> {
    @Modifying
    @Transactional
    @Query(value = "ALTER table rayon AUTO_INCREMENT=1"
            , nativeQuery = true)
    void reset_auto_increment();
    @Modifying
    @Transactional
    @Query(value = "ALTER table rayon AUTO_INCREMENT=?1"
            , nativeQuery = true)
    void fix_auto_increment(int value);
}
