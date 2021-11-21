package com.example.demo.tn.esprit.spring.service;

import com.example.demo.Entities.Stock;

import java.util.List;

public interface StockService {
    List<Stock> retrieveAllStocks();
    Stock addStock(Stock s);
    Stock updateStock(Stock u);
    Stock retrieveStock(Long id);
    void deleteStock(Long id);
    String retrieveStatusStock();
}
