package com.example.demohibernate;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by phann on 7/26/2017.
 */
@RestController
public class APIResource {

    @RequestMapping("/hello")
    public String hello(){
        return "Hello";
    }
}
