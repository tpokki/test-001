package com.example.demo.rest;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
@Path("/")
public class Standalone {
    private static final Log LOG = LogFactory.getLog(Standalone.class);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/v2/string/{id}")
    public String get(
            @NotNull @PathParam("id") @Pattern(regexp="^[a-z]{2,5}$") String id,
            @QueryParam("p") @Min(0) @Max(3) @DefaultValue("2") Integer param) {

        LOG.info(id);
        LOG.info(param * 42);
        return id + param;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/v2/vulnerable/{id}")
    public String vulnerable(@NotNull @PathParam("id") String id, @QueryParam("p") @DefaultValue("2") Integer param) {
        LOG.info(id);
        LOG.info(param * 42);
        return id + param;
    }}
