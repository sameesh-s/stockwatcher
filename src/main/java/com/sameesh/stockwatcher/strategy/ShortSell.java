package com.sameesh.stockwatcher.strategy;


import com.sameesh.stockwatcher.dto.Stock;
import com.sameesh.stockwatcher.entity.TickPoint;
import com.sameesh.stockwatcher.util.Stack;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ShortSell implements StockSelectionStrategy {

    @Override
    public List<Stock> rank(List<Stock> wishList) {
        wishList.parallelStream().forEach((item) -> {
            computeProximity(item);
        });
        return wishList.stream().sorted(Comparator.comparing(Stock::getProximity).reversed()).collect(Collectors.toList());
    }

    private void computeProximity(Stock stock){
        Stack<TickPoint> stack = new Stack<>();
        int proximity = 0;
        for(TickPoint tick: stock.getTicks()){
            System.out.println(tick.calcWickSize());
            if(tick.calcWickSize() > 30){
                proximity = proximity + 10;
                if(!stack.isEmpty()){
                    TickPoint prvTick = stack.peek();
                    if(prvTick.getLow() < tick.getLow()){
                       proximity = proximity -5;
                    }else if(prvTick.getHigh() < tick.getHigh()){
                        stack.push(tick);
                    }else{
                        proximity = proximity -1;
                        stack.pop();
                    }
                }
            }
        }
        stock.setProximity(proximity);
    }

}
