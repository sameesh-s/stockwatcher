package com.sameesh.stockwatcher.repository;

import com.sameesh.stockwatcher.entity.WishListEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class WishListRepository {

    private static final String NAME_FIELD = "name";

    @Autowired
    MongoTemplate mongoTemplate;

    public WishListEntity create(WishListEntity wishListEntity){
        return mongoTemplate.save(wishListEntity);
    }

    public Optional<WishListEntity> findByName(String wishlistName) {
        Query query = new Query();
        query.addCriteria(Criteria.where(NAME_FIELD).is(wishlistName));
        return Optional.ofNullable(mongoTemplate.findOne(query, WishListEntity.class));
    }

    public WishListEntity save(WishListEntity wishListEntity) {
        return mongoTemplate.save(wishListEntity);
    }

    public List<WishListEntity> findAll() {
        return mongoTemplate.findAll(WishListEntity.class);
    }
}
