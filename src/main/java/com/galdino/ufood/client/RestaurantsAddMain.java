package com.galdino.ufood.client;

import com.galdino.ufood.client.api.ClientApiException;
import com.galdino.ufood.client.api.RestaurantClient;
import com.galdino.ufood.client.model.*;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

public class RestaurantsAddMain {
    public static void main(String[] args) {
        try {
            RestTemplate restTemplate = new RestTemplate();

            RestaurantClient restaurantClient = new RestaurantClient(restTemplate, "http://localhost:8080");

            City city = City.builder()
                            .id(null)
                            .build();

            Address address = Address.builder()
                                     .zipCode("123456")
                                     .street("5th Avenue")
                                     .number("75A")
                                     .complement(null)
                                     .district("Downtown")
                                     .city(city)
                                     .build();

            Kitchen kitchen = Kitchen.builder()
                                     .id(1L)
                                     .build();

            RestaurantInput restaurantInput = RestaurantInput.builder()
                                                             .name(null)
                                                             .deliveryFee(new BigDecimal(5))
                                                             .kitchen(kitchen)
                                                             .address(address)
                                                             .build();

            RestaurantSummaryModel restaurantSummaryModel = restaurantClient.add(restaurantInput);
            System.out.println(restaurantSummaryModel);
        } catch (ClientApiException e) {
            if (e.getProblem() != null) {
                System.out.println(e.getProblem());
                System.out.println(e.getProblem().getUserMessage());
                e.getProblem().getObjects().forEach(objects -> System.out.println("- " + objects.getUserMessage()));
            } else {
                System.out.println("Unknown error.");
            }
        }
    }
}
