package com.sameesh.stockwatcher.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(description = "Details of the stock tick")
public class TickPoint {
    private int open;
    private int high;
    private int low;
    private int close;

    public float calcWickSize(){
        float totalSize = this.high- this.low;
        return ((Math.abs(low - close))/totalSize ) * 100;
    }
}
