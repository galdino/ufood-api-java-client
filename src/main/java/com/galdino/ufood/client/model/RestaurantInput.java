package com.galdino.ufood.client.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class RestaurantInput {
    private String name;
    private BigDecimal deliveryFee;
    private Kitchen kitchen;
    private Address address;
}
