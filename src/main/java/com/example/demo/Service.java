package com.example.demo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class Service {
    private static final Log LOG = LogFactory.getLog(Service.class);

    public String badCode(String string, Integer number) {
        LOG.info(string);
        LOG.info(number * 42);
        return string + number;
    }
}
