package com.sameesh.stockwatcher.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document("wishlists")
public class WishListEntity {

    @Id
    private String id;
    private String name;
    private List<String> stockIds;
}
