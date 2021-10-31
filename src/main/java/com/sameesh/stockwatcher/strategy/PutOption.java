package com.sameesh.stockwatcher.strategy;

import com.sameesh.stockwatcher.dto.Stock;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class PutOption implements StockSelectionStrategy {

    @Override
    public List<Stock> rank(List<Stock> wishList) {
        wishList.parallelStream().forEach((item) -> {
            computeProximity(item);
        });
        return wishList.stream().sorted(Comparator.comparing(Stock::getProximity).reversed()).collect(Collectors.toList());
    }

    private void computeProximity(Stock stock){
        Random rd = new Random();
        stock.setProximity(rd.nextFloat());
    }
}
