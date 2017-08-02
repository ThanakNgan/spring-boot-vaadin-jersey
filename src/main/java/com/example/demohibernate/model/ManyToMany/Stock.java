package com.example.demohibernate.model.ManyToMany;

import javax.persistence.*;
import java.util.List;

/**
 * Copyright (c) GL Finance Plc. All rights reserved. (http://www.gl-f.com/)
 * Author: Thanak Ngan (t.ngan@gl-f.com) on 8/2/2017.
 */
@Entity
@Table(name = "tb_stock", catalog = "mkyongdb", uniqueConstraints = {
        @UniqueConstraint(columnNames = "stock_name"),
        @UniqueConstraint(columnNames = "stock_id") })
public class Stock {

  @Id
  @GeneratedValue
  @Column(name = "stock_id", nullable = false)
  private Long id;

  @Column(name = "stock_name", length = 50, nullable = false)
  private String name;

  @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinTable(name = "stock_category", catalog = "mkyongdb", joinColumns = {
          @JoinColumn(name = "stock_id", nullable = false, updatable = false) },
          inverseJoinColumns = { @JoinColumn(name = "category_id",
                  nullable = false, updatable = false) })
  private List<Category> categories;

  public Stock(){

  }
  public Stock(String name, List<Category> categories) {
    this.name = name;
    this.categories = categories;
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

  public List<Category> getCategories() {
    return categories;
  }

  public void setCategories(List<Category> categories) {
    this.categories = categories;
  }
}
