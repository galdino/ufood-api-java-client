package com.galdino.ufood.client.api;

import com.galdino.ufood.client.model.RestaurantInput;
import com.galdino.ufood.client.model.RestaurantSummaryModel;
import lombok.AllArgsConstructor;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
public class RestaurantClient {

    private static final String RESOURCE_PATH = "/restaurants";

    private RestTemplate restTemplate;
    private String url;

    public List<RestaurantSummaryModel> list() {
        try {
            URI uri = URI.create(url + RESOURCE_PATH);

            RestaurantSummaryModel[] restaurantSummaryModels = restTemplate.getForObject(uri, RestaurantSummaryModel[].class);

            return Arrays.asList(restaurantSummaryModels != null ? restaurantSummaryModels : new RestaurantSummaryModel[0]);
        } catch (RestClientResponseException e) {
            throw new ClientApiException(e.getMessage(), e);
        }
    }

    public RestaurantSummaryModel add(RestaurantInput restaurantInput) {
        try {
            URI uri = URI.create(url + RESOURCE_PATH);

            return restTemplate.postForObject(uri, restaurantInput, RestaurantSummaryModel.class);
        } catch (RestClientResponseException e) {
            throw new ClientApiException(e.getMessage(), e);
        }
    }

}
