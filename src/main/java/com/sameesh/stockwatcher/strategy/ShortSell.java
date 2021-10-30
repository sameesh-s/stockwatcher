package com.sameesh.stockwatcher.strategy;


import com.sameesh.stockwatcher.dto.Stock;

import java.util.List;

public class ShortSell implements StockSelectionStrategy {

    @Override
    public List<Stock> rank(List<Stock> wishList) {
        return null;
    }

    /**
     * Method for calculating proximity for every stock, based on proximity we rank the stock.
     * @param stock Stock Object
     * @return
     */
    private Float calculateProximity(Stock stock) {
        return null;
    }

}
