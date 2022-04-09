package com.example.demo.rest;

import javax.ws.rs.Path;

import com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/v2")
public class ApiV2 implements Interface {
    @Autowired
    private Service service;

    @Override
    public String safe(String id, Integer param) {
        return service.badCode(id, param);
    }

    @Override
    public String notSafe(String id, Integer param) {
        return service.badCode(id, param);
    }
}
