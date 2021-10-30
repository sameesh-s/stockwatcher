package com.sameesh.stockwatcher.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sameesh.stockwatcher.dto.Stock;
import com.sameesh.stockwatcher.entity.StockEntity;
import com.sameesh.stockwatcher.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("stockService")
public class StockService {

    @Autowired
    StockRepository stockRepository;

    private static final ObjectMapper mapper = new ObjectMapper();

    public Stock createStock(Stock stockDTO){
        StockEntity savingStock = mapper.convertValue(stockDTO, StockEntity.class);
        return mapper.convertValue(stockRepository.save(savingStock), Stock.class);
    }

    public List<Stock> getAllStocks() {
        return stockRepository.getAll().stream()
                .map(item -> mapper.convertValue(item, Stock.class))
                .collect(Collectors.toList());
    }
}
