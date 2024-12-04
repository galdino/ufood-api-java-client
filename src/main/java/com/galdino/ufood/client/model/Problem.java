package com.galdino.ufood.client.model;

import lombok.Data;

import java.time.OffsetDateTime;
import java.util.List;

@Data
public class Problem {

    private Integer status;
    private OffsetDateTime timestamp;
    private String userMessage;
    private List<Objects> objects;

    @Data
    public static class Objects {
        private String name;
        private String userMessage;
    }

}
