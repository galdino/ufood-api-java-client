package com.galdino.ufood.client.api;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.galdino.ufood.client.model.Problem;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestClientResponseException;

import java.io.IOException;

@Slf4j
public class ClientApiException extends RuntimeException {

    @Getter
    private Problem problem;
    public ClientApiException(String message, RestClientResponseException cause) {
        super(message, cause);
        deserializeProblem(cause);
    }

    private void deserializeProblem(RestClientResponseException cause) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.registerModule(new JavaTimeModule());
        mapper.findAndRegisterModules();

        try {
            this.problem = mapper.readValue(cause.getResponseBodyAsString(), Problem.class);
        } catch (IOException e) {
            log.warn("Problem deserialization error.");
        }
    }
}
