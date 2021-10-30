package com.sameesh.stockwatcher.controller;

import com.sameesh.stockwatcher.dto.Stock;
import com.sameesh.stockwatcher.service.StockService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class StockController {


    @Autowired
    StockService stockService;

    @GetMapping("/stocks")
    @ApiOperation(value = "Find all the stocks available",
            notes="provide details of available stocks",
            response = Stock.class,
            responseContainer = "List",
            code=200
    )
    public List<Stock> getAll(){
        return stockService.getAllStocks();
    }

    @PostMapping("/stocks")
    @ApiOperation(value = "Create new stock",
            notes= "create new stock",
            response= Stock.class,
            code=200
    )
    public Stock create(@RequestBody Stock stock){
        return stockService.createStock(stock);
    }

}
