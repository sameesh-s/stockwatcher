package com.sameesh.stockwatcher.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "Details about the stock")
public class Stock {

    private String id;
    @ApiModelProperty(notes="name of the stock")
    private String name;
}
