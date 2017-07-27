package com.example.demohibernate.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Created by phann on 7/26/2017.
 */
@Path("/hi")
public class APIResource {

    @GET
    public String hello(){
        return "Hello bb";
    }
}
