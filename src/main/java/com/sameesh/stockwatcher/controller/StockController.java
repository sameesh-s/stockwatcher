package com.sameesh.stockwatcher.controller;

import com.sameesh.stockwatcher.dto.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockController {

    @Autowired
    MongoTemplate mongoTemplate;

    @PostMapping("/stocks")
    public String create(@RequestBody Stock stock){
        mongoTemplate.save(stock,"stocks");
        return stock.getName();
    }

}
