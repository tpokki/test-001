package com.example.demo.rest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class FromInterface implements API {
    private static final Log LOG = LogFactory.getLog(FromInterface.class);

    @Override
    public String get(String id, Integer param) {
        LOG.info(id);
        LOG.info(param * 42);
        return id + param;
    }

}
