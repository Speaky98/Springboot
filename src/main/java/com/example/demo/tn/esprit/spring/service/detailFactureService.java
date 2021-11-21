package com.example.demo.tn.esprit.spring.service;

import com.example.demo.Entities.detailFacture;

public interface detailFactureService {
    detailFacture adddetailFacture(detailFacture df);
    void deletedetailFacture(Long id);
}
