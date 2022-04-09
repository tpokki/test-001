package com.example.demo;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.example.demo.rest.Standalone;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(Standalone.class);
    }
}