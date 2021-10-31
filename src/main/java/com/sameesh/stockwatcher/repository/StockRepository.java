package com.sameesh.stockwatcher.repository;

import com.sameesh.stockwatcher.entity.StockEntity;
import com.sameesh.stockwatcher.entity.WishListEntity;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
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

    public StockEntity findById(String stockId) {
        Query query = new Query();
        if(stockId!=null) {
            query.addCriteria(Criteria.where("_id").is(new ObjectId(stockId)));
        }
        return mongoTemplate.findOne(query, StockEntity.class);
    }
}
