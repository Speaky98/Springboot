package com.example.demo;

import com.example.demo.tn.esprit.spring.repository.FactureRepository;
import com.example.demo.tn.esprit.spring.service.FactureService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class FactureTests {
    @Autowired
    private FactureService factureService;

    @Autowired
    private FactureRepository factureRepository;

    @Test
    void DisplayFactures() {
        this.factureService.retrieveAllFactures().forEach((facture -> {
            log.info(facture.toString());
        }));
    }
    @Test
    void UpadteFacture() {
        this.factureService.cancelFacture(1L);
    }
    @Test
    void DiplayFacture() {
        log.info(this.factureService.retrieveFacture(2L).toString());
    }
}
