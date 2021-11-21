package com.example.demo;

import com.example.demo.Entities.Stock;
import com.example.demo.tn.esprit.spring.repository.StockRepository;

import com.example.demo.tn.esprit.spring.service.StockService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class StockTests {
   @Autowired
    private StockService stockService;

    @Autowired
    private StockRepository stockRepository;

    @Test
    void AddStock() {
        Stock stock_1=new Stock();
        stock_1.setLibelleStock("Bureautique");
        stock_1.setQte(10);
        stock_1.setQteMin(20);
        stockService.addStock(stock_1);
    }
    @Test
    void DisplayStock() {
                log.info(this.stockService.retrieveStock(2L).toString());

    }
    @Test
    void DisplayStocks() {
        for (Stock s:
                this.stockService.retrieveAllStocks()) {
            log.info(s.toString());
        }
    }
    @Test
    void UpdateStock() {
        Stock stock_1=this.stockRepository.findById(4L).get();
        stock_1.setLibelleStock("jackie");
        this.stockService.updateStock(stock_1);
    }
    @Test
    void DeleteStock() {}
}
