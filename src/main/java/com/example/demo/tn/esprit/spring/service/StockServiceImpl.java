package com.example.demo.tn.esprit.spring.service;

import com.example.demo.Entities.Stock;
import com.example.demo.tn.esprit.spring.repository.StockRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Slf4j
@Service
public class StockServiceImpl implements StockService{
    @Autowired
    private StockRepository stockRepository;
    @Override
    public List<Stock> retrieveAllStocks() {return (List<Stock>) this.stockRepository.findAll();}

    @Override
    public Stock addStock(Stock s) {
        return this.stockRepository.save(s);
    }

    /** setter ... **/
    @Override
    public Stock updateStock(Stock s) {
        /*Stock stock_1=this.stockRepository.findById(s.getIdStock()).get();
        stock_1.setLibelleStock(s.getLibelleStock());
        stock_1.setQte(s.getQte());*/
        return this.stockRepository.save(s);
    }

    @Override
    public Stock retrieveStock(Long id) {return this.stockRepository.findById(id).get();}

    @Override
    public void deleteStock(Long id) {
        this.stockRepository.deleteById(id);
    }

    @Scheduled(cron = "0 0 22 * * *")
    @Override
    public String retrieveStatusStock() {
        AtomicReference<String> avert= new AtomicReference<>("");
       this.stockRepository.findAll().forEach(stock -> {
           if(stock.getQte()<stock.getQteMin())
               avert.set("Attention Qte < QteMin");
       });
       log.info(avert.get());
       return avert.get();
    }
}
