package com.sameesh.stockwatcher.strategy;

import com.sameesh.stockwatcher.dto.Stock;

import java.util.List;

public interface StockSelectionStrategy {

    /**
     * Here we will rank the stock according to the strategy
     * @param wishList List of Stock Object
     * @return List of Stock Object with computed Rank
     */
    public List<Stock> rank(List<Stock> wishList);

}
