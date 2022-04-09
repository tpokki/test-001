package com.example.demo;

import com.example.demo.rest.ApiV1;
import com.example.demo.rest.ApiV2;
import com.example.demo.rest.ApiV3;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(ApiV1.class);
        register(ApiV2.class);
        register(ApiV3.class);
    }
}