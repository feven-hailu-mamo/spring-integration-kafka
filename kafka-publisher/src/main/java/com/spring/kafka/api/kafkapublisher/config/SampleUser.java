package com.spring.kafka.api.kafkapublisher.config;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SampleUser {
    private int id;
    private String name;
    private String[] address;

    public SampleUser(int id, String name, String[] address) {
        this.id = id;
        this.name = name;
        this.address = address;

    }
}
