package com.sameesh.stockwatcher.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sameesh.stockwatcher.entity.TickPoint;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(description = "Details about the stock")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Stock {

    private String id;
    @ApiModelProperty(notes="name of the stock")
    private String name;
    @ApiModelProperty(notes="rank is used for giving bestfit stop for the client")
    @JsonIgnore
    private Integer rank;

    private float proximity;
    private List<TickPoint> ticks;
}
