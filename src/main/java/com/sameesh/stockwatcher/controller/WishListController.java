package com.sameesh.stockwatcher.controller;

import com.sameesh.stockwatcher.dto.ApiError;
import com.sameesh.stockwatcher.dto.Stock;
import com.sameesh.stockwatcher.dto.WishList;
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

    private static final Logger LOGGER = LoggerFactory.getLogger(WishListController.class);

    @Autowired
    WishListService wishListService;

    @GetMapping("/wishlist/")
    public List<WishList> getAllWishList() throws BusinessException {
        return wishListService.findAll();
    }

    @GetMapping("/wishlist/{wishlistname}")
    public WishList getWishListByName(@PathVariable("wishlistname") String wishlistName) throws BusinessException {
        return wishListService.findByName(wishlistName);
    }


    @DeleteMapping("/wishlist/{wishlistname}")
    public Boolean deleteWishListByName(@PathVariable("wishlistname") String wishlistName) throws BusinessException {
        return wishListService.deleteByName(wishlistName);
    }

    @PostMapping("/wishlist/")
    public WishList create(@RequestBody WishList wishList){
        return wishListService.create(wishList);
    }

    @GetMapping("wishlist/{wishlistname}/strategy/{strategy}")
    public Object applyStrategy(@PathVariable("wishlistname") String wishlistName,
                                        @PathVariable("strategy") String strategy) throws BusinessException {
            return wishListService.applyStrategy(wishlistName, strategy);
    }

}
