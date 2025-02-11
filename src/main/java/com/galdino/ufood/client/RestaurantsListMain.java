package com.galdino.ufood.client;

import com.galdino.ufood.client.api.ClientApiException;
import com.galdino.ufood.client.api.RestaurantClient;
import org.springframework.web.client.RestTemplate;

public class RestaurantsListMain {
    public static void main(String[] args) {
        try {
            RestTemplate restTemplate = new RestTemplate();

            RestaurantClient restaurantClient = new RestaurantClient(restTemplate, "http://localhost:8080");
            restaurantClient.list().forEach(System.out::println);
        } catch (ClientApiException e) {
            if (e.getProblem() != null) {
                System.out.println(e.getProblem());
                System.out.println(e.getProblem().getUserMessage());
            } else {
                System.out.println("Unknown error.");
            }
        }
    }
}
