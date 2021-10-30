package com.sameesh.stockwatcher.controller;

import com.sameesh.stockwatcher.dto.Stock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class WishListController {

    private static final Logger log = LoggerFactory.getLogger(WishListController.class);

    @GetMapping("/wishlist")
    public List<String> getAllWishlist(){
        List<String> wishlist = new ArrayList<>();
        wishlist.add("SIKL");
        wishlist.add("FFFD");
        return wishlist;
    }

    @GetMapping("/wishlist/{name}")
    public String findItemByName(@PathVariable("name") String name){
        return  name;
    }

    @PostMapping("/wishlist")
    public String create(@RequestBody Stock createdStock){
        log.warn("inside creation of wishlist item");
        return createdStock.getName();
    }

}
