package com.example.demohibernate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by phann on 8/3/2017.
 */
@Controller
public class SwaggerController {

    @RequestMapping(value = "/hi")
    @ResponseBody
    public String sayHello(){
        return "hi";
    }

    @RequestMapping(value = "/doc")
    public String swagger(){
        return "index";
    }
}
