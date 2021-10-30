package com.sameesh.stockwatcher.service;

import com.sameesh.stockwatcher.dto.Stock;
import com.sameesh.stockwatcher.exception.BusinessException;
import com.sameesh.stockwatcher.repository.WishListRepository;
import com.sameesh.stockwatcher.strategy.StockSelectionStrategy;
import com.sameesh.stockwatcher.strategy.StockStrategyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WishListService {


    @Autowired
    WishListRepository wishListRepository;

    /**
     * Rank given stock in the basis of applied strategy
     * @param wishlistName
     * @param strategyName
     * @return
     * @throws BusinessException
     */
    public List<Stock> applyStrategy(String wishlistName, String strategyName) throws BusinessException {
        StockSelectionStrategy strategy = StockStrategyFactory.getStrategy(strategyName);
        System.out.println(strategy);
        List<Stock> stocks = new ArrayList<>();
        return strategy.rank(stocks);
    }

    public WishList findByName(String wishlistName) {
        wishListRepository.findByName(wishlistName);
        return null;
    }
}
