package com.sameesh.stockwatcher.controller;

import com.sameesh.stockwatcher.dto.Stock;
import com.sameesh.stockwatcher.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StockController {


    @Autowired
    StockService stockService;

    @GetMapping("/stocks")
    public List<Stock> getAll(){
        return stockService.getAllStocks();
    }

    @PostMapping("/stocks")
    public Stock create(@RequestBody Stock stock){
        return stockService.createStock(stock);
    }

}
