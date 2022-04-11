package com.example.demo.rest;

import javax.ws.rs.BadRequestException;

import com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApiV1 implements Interface {
    @Autowired
    private Service service;

    @Override
    public String safe(String id, Integer param) {
        return service.badCode(id, param);
    }

    @Override
    public String explicit(String id, Integer param) {
        if(param >= 0 && param < 4 && id.matches("[a-z]{2,5}")) {
            return service.badCode(id, param);
        } else {
            throw new BadRequestException();
        }
    }

    @Override
    public String notSafe(String id, Integer param) {
        return service.badCode(id, param);
    }
}
