package com.example.demohibernate.model.oneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;

/**
 * Copyright (c) GL Finance Plc. All rights reserved. (http://www.gl-f.com/)
 * Author: Thanak Ngan (t.ngan@gl-f.com) on 8/2/2017.
 */
@Entity
@Table(name = "product")
public class Product {

  @Id
  @Column(name = "PRODUCT_ID")
  @GeneratedValue
  private Long id;

  @Column(name = "PRODUCT_NAME", length = 50, nullable = false)
  private String name;

  @Column(name = "price", nullable = false)
  private double price;

  @Column(name = "description")
  private String description;

  @ManyToOne
  @JoinColumn(name = "CATEGORY_ID")
  @LazyCollection(LazyCollectionOption.FALSE)
  @JsonBackReference
  private Category category;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }
}
