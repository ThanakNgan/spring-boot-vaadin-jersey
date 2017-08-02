package com.example.demohibernate.model.ManyToMany;

import javax.persistence.*;
import java.util.List;

/**
 * Copyright (c) GL Finance Plc. All rights reserved. (http://www.gl-f.com/)
 * Author: Thanak Ngan (t.ngan@gl-f.com) on 8/2/2017.
 */
@Entity
@Table(name = "tb_category", catalog = "mkyongdb")
public class Category {

  @Id
  @Column(name = "category_id")
  @GeneratedValue
  private Long id;

  @Column(name = "category_name", length = 50, nullable = false)
  private String name;

  @ManyToMany(fetch = FetchType.LAZY, mappedBy = "categories")
  private List<Stock> stocks;

  public Category(String name, List<Stock> stocks) {
    this.name = name;
    this.stocks = stocks;
  }

  public Category(){

  }

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

  public List<Stock> getStocks() {
    return stocks;
  }

  public void setStocks(List<Stock> stocks) {
    this.stocks = stocks;
  }
}
