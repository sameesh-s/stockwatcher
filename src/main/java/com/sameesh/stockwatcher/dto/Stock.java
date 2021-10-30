package com.sameesh.stockwatcher.dto;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("stocks")
public class Stock {
    @Id
    private String id;
    private String name;
}
