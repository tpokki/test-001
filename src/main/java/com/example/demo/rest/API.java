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

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public interface API {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/v1/string/{id}")
    String get(
            @NotNull @PathParam("id") @Pattern(regexp="^[a-z]{2,5}$") String id,
            @QueryParam("p") @Min(0) @Max(3) @DefaultValue("2") Integer param);
}
