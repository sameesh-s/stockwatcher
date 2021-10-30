package com.sameesh.stockwatcher.strategy;

import com.sameesh.stockwatcher.dto.Stock;

import java.util.List;

public class PassiveRanking implements StockSelectionStrategy {
    @Override
    public List<Stock> rank(List<Stock> wishList) {
        return null;
    }
}
