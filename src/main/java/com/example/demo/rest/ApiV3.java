package com.example.demo.rest;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/v3")
public class ApiV3 {
    @Autowired
    private Service service;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/safe/{id}")
    public String safe(
            @NotNull @PathParam("id") @Pattern(regexp="^[a-z]{2,5}$") String id,
            @QueryParam("p") @Min(0) @Max(3) @DefaultValue("2") Integer param) {

        return service.badCode(id, param);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/explicit/{id}")
    public String explicit(
            @NotNull @PathParam("id") @Pattern(regexp="^[a-z]{2,5}$") String id,
            @QueryParam("p") @Min(0) @Max(3) @DefaultValue("2") Integer param) {

        if(param >= 0 && param < 4 && id.matches("[a-z]{2,5}")) {
            return service.badCode(id, param);
        } else {
            throw new BadRequestException();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/not/{id}")
    public String notSafe(@NotNull @PathParam("id") String id, @QueryParam("p") @DefaultValue("2") Integer param) {
        return service.badCode(id, param);
    }
}
