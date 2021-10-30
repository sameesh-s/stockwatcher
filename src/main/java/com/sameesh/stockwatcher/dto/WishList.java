package com.sameesh.stockwatcher.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WishList {

    private String id;
    private String name;
    private List<Stock> stocks;

}
