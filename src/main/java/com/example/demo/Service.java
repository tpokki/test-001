package com.example.demo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class Service {
    private static final Log LOG = LogFactory.getLog(Service.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String badCode(String string, Integer number) {
        LOG.info(string);
        LOG.info(number * 42);
        if(number > 2) {
            jdbcTemplate.queryForObject("SELECT * FROM bad_code WHERE input='"+string+"'", String.class);
        }
        return string + number;
    }
}
