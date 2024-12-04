package com.galdino.ufood.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class RestaurantSummaryModel {
    private Long id;
    private String name;
    private BigDecimal deliveryFee;

    @JsonProperty("kitchen")
    private KitchenModel kitchenModel;
}
