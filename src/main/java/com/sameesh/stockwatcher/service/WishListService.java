package com.sameesh.stockwatcher.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sameesh.stockwatcher.controller.WishListController;
import com.sameesh.stockwatcher.dto.Stock;
import com.sameesh.stockwatcher.dto.WishList;
import com.sameesh.stockwatcher.entity.StockEntity;
import com.sameesh.stockwatcher.entity.WishListEntity;
import com.sameesh.stockwatcher.exception.BusinessException;
import com.sameesh.stockwatcher.repository.StockRepository;
import com.sameesh.stockwatcher.repository.WishListRepository;
import com.sameesh.stockwatcher.strategy.StockSelectionStrategy;
import com.sameesh.stockwatcher.strategy.StockStrategyFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WishListService {

    private static final ObjectMapper mapper = new ObjectMapper();

    private static final Logger LOGGER = LoggerFactory.getLogger(WishListService.class);

    @Autowired
    WishListRepository wishListRepository;

    @Autowired
    StockRepository stockRepository;
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

    public WishList findByName(String wishlistName) throws BusinessException {
        Optional<WishListEntity> wishListResultSet = wishListRepository.findByName(wishlistName);
        if(wishListResultSet.isPresent()){
            return  mapper.convertValue(wishListResultSet.get(), WishList.class);
        }else{
            throw new BusinessException("Wishlist with name " + wishlistName+" dosn't exist...");
        }
    }


    public List<WishList> findAll() {
        return wishListRepository.findAll().stream()
                .map(item -> {
                    WishList wishList = mapper.convertValue(item, WishList.class);
                    wishList.setStocks(item.getStockIds().stream()
                            .map(stockId -> mapper.convertValue(stockRepository.findById(stockId), Stock.class))
                            .collect(Collectors.toList()));
                    return  wishList;})
                .collect(Collectors.toList());
    }

    public WishList create(WishList wishList) {
        List<Stock> stockDtos = wishList.getStocks();
        LOGGER.warn("Wishlist " + wishList.getName() + " has stock size : " + stockDtos.size());
        WishListEntity wishListEntity = mapper.convertValue(wishList, WishListEntity.class);
        if(stockDtos.size() > 0){
            wishList.setStocks(
            stockDtos.stream()
                    .map(item ->{
                        item = mapper.convertValue(stockRepository.save(mapper.convertValue(item, StockEntity.class)), Stock.class);
                        return item;
                    })
                    .collect(Collectors.toList())
            );
            wishListEntity.setStockIds(wishList.getStocks().stream().map(Stock::getId).collect(Collectors.toList()));
        }
        wishList.setId(wishListRepository.save(wishListEntity).getId());
        return wishList;
    }
}
