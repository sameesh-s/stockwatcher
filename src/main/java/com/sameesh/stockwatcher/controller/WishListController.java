package com.sameesh.stockwatcher.controller;

import com.sameesh.stockwatcher.dto.ApiError;
import com.sameesh.stockwatcher.dto.Stock;
import com.sameesh.stockwatcher.exception.BusinessException;
import com.sameesh.stockwatcher.service.WishListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class WishListController {

    private static final Logger log = LoggerFactory.getLogger(WishListController.class);

    @Autowired
    WishListService wishListService;

    @GetMapping("/wishlist/{wishlistname}")
    public WishList getAllWishlist(@PathVariable("wishlistname") String wishlistName){
        return wishListService.findByName(wishlistName);
    }

    @GetMapping("wishlist/{wishlistname}/strategy/{strategy}")
    public Object applyStrategy(@PathVariable("wishlistname") String wishlistName,
                                        @PathVariable("strategy") String strategy){
        System.out.println(strategy);
        System.out.println(wishlistName);
        try {
            return wishListService.applyStrategy(wishlistName, strategy);
        } catch (BusinessException e) {
            e.printStackTrace();
            return new ApiError(e.getMessage());
        }
    }

    @GetMapping("/wishlist/{name}")
    public String findItemByName(@PathVariable("name") String name){
        return  name;
    }


}
