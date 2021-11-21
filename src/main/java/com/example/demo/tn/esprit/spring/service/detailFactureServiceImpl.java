package com.example.demo.tn.esprit.spring.service;

import com.example.demo.Entities.detailFacture;
import com.example.demo.tn.esprit.spring.repository.detailFactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class detailFactureServiceImpl implements detailFactureService{
    @Autowired
    detailFactureRepository detailFactureRepository;
    @Override
    public detailFacture adddetailFacture(detailFacture df) {
        return this.detailFactureRepository.save(df);
    }

    @Override
    public void deletedetailFacture(Long id) {
        this.detailFactureRepository.deleteById(id);
    }
}
