package com.sameesh.stockwatcher.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document("stocks")
public class StockEntity {
    @Id
    private String id;
    private String name;
    private List<TickPoint> ticks;
}