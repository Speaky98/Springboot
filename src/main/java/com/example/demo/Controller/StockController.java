package com.example.demo.Controller;

import com.example.demo.Entities.Stock;
import com.example.demo.tn.esprit.spring.service.StockService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StockController {
    @Autowired
    StockService stockService;

    @RequestMapping(value = "/Stock",method = RequestMethod.POST,produces="application/json", consumes="application/json")
    public Stock retrieveStock(@RequestBody String json) throws JSONException {
        JSONObject jsonRequest=new JSONObject(json);
        Integer id= (Integer) jsonRequest.get("id");
        return this.stockService.retrieveStock(Long.valueOf(id));
    }

    @RequestMapping(value = "/Stocks",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Stock> retrieveAllStocks(){
        return this.stockService.retrieveAllStocks();
    }

    @RequestMapping(value = "/Stock/Add",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public Stock Add(@RequestBody Stock stock){
        return this.stockService.addStock(stock);
    }

    @RequestMapping(value = "/Stock/Update",method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
    public Stock Update(@RequestBody Stock stock){
        return this.stockService.updateStock(stock);
    }
}
