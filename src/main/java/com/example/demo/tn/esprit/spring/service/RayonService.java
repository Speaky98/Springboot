package com.example.demo.tn.esprit.spring.service;

import com.example.demo.Entities.Rayon;

import java.util.List;

public interface RayonService {
    List<Rayon> retrieveAllRayons();
    Rayon addRayon(Rayon r);
    void deleteRayon(Long id);
    Rayon updateRayon(Rayon r);
    Rayon retrieveRayon(Long id);
}
