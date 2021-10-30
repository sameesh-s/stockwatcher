package com.sameesh.stockwatcher.repository;

import com.sameesh.stockwatcher.entity.StockEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StockRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    public StockEntity save(StockEntity stockEntity){
        return  mongoTemplate.save(stockEntity);
    }

    public List<StockEntity> getAll() {
        return mongoTemplate.findAll(StockEntity.class);
    }
}
