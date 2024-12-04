package com.galdino.ufood.client.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {
    private String zipCode;
    private String street;
    private String number;
    private String complement;
    private String district;
    private City city;
}
