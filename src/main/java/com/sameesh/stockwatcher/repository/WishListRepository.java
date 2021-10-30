package com.sameesh.stockwatcher.repository;

import com.sameesh.stockwatcher.entity.WishListEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class WishListRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    public WishListEntity create(WishListEntity wishListEntity){
        return mongoTemplate.save(wishListEntity, WishListEntity.class);
    }

    public void findByName(String wishlistName) {
        Query query = new Query();
        return mongoTemplate.find()
    }
}
