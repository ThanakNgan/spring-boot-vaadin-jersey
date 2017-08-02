package com.example.demohibernate.resources;

import com.example.demohibernate.model.ManyToMany.Stock;
import com.example.demohibernate.model.oneToMany.Category;
import com.example.demohibernate.model.oneToMany.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (c) GL Finance Plc. All rights reserved. (http://www.gl-f.com/)
 * Author: Thanak Ngan (t.ngan@gl-f.com) on 8/2/2017.
 */
@Controller
@Transactional
public class TestController {

  @Autowired
  private SessionFactory sessionFactory;

  private Session getSession() {
    return sessionFactory.getCurrentSession();
  }

  public void save(){
    Category category =new Category();
    category.setName("Phone");

    Product product = new Product();
    product.setDescription("Good product");
    product.setPrice(300.90);
    product.setName("Iphone6");
    product.setCategory(category);

    Product product1 = new Product();
    product1.setDescription("Good product");
    product1.setPrice(600);
    product1.setName("Galaxy s8 edge");
    product1.setCategory(category);

    List<Product> products = new ArrayList<>();
    products.add(product);
    products.add(product1);

    category.setProducts(products);

    getSession().save(category);

  }

  public void saveStockCategory(){

    Stock stock = new Stock();

    stock.setName("KH");

    com.example.demohibernate.model.ManyToMany.Category category1 = new com.example.demohibernate.model.ManyToMany.Category();
    category1.setName("Iphone");

    com.example.demohibernate.model.ManyToMany.Category category2 = new com.example.demohibernate.model.ManyToMany.Category();
    category2.setName("Samsung");

    List<com.example.demohibernate.model.ManyToMany.Category> categories = new ArrayList<>();
    categories.add(category1);
    categories.add(category2);

    stock.setCategories(categories);

    getSession().save(stock);

  }

  public List<Category> getAllCategory(){
    return getSession().createCriteria(Category.class).list();
  }
}
