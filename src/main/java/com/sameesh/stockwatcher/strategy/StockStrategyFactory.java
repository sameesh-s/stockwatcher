package com.sameesh.stockwatcher.strategy;

import com.sameesh.stockwatcher.exception.BusinessException;

import static com.sameesh.stockwatcher.strategy.Strategy.*;

/**
 * Abstract factory class for Stragtegy creation
 */
public class StockStrategyFactory {

    public static StockSelectionStrategy getStrategy(String strategyName) throws BusinessException {
        Strategy strategy = Strategy.fromString(strategyName);
        switch (strategy){
            case SHORTSELL: return new ShortSell();
            case PUTOPTION: return new PutOption();
            default : return new PassiveRanking();
        }
    }

}
