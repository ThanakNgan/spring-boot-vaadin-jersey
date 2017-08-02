package com.example.demohibernate;

import com.example.demohibernate.model.oneToMany.Category;
import com.example.demohibernate.resources.TestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by phann on 7/26/2017.
 */
@RestController
public class APIResource {

    @Autowired
    private TestController testController;

   /* @RequestMapping("/carts")
    public List<Cart> hello(){
        return cartController.getAllCart();
    }*/

    @RequestMapping("/hello")
    public String sayHello(){
        testController.save();
        return "hello";
    }

    @RequestMapping("/cats")
    public List<Category> getAll(){
        return  testController.getAllCategory();
    }
}
