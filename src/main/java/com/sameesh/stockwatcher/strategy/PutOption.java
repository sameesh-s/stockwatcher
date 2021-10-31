package com.sameesh.stockwatcher.strategy;

import com.sameesh.stockwatcher.dto.Stock;
import com.sameesh.stockwatcher.entity.TickPoint;
import com.sameesh.stockwatcher.util.Stack;

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
        Stack<TickPoint> stack = new Stack<>();
        int proximity = 0;
        for(TickPoint tick: stock.getTicks()){
            if(tick.calcWickSize() > 20){
                proximity = proximity + 8;
                if(!stack.isEmpty()){
                    TickPoint prvTick = stack.peek();
                    if(prvTick.getLow() < tick.getLow()){
                        proximity = proximity +3;
                    }else if(prvTick.getHigh() < tick.getHigh()){
                        stack.push(tick);
                    }else{
                        proximity = proximity -2;
                        stack.pop();
                    }
                }
            }
        }
        stock.setProximity(Math.abs(proximity));
    }

}
