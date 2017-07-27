package com.example.demohibernate.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by phann on 7/26/2017.
 */
@Entity
@Table(name = "tb_student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    @Column(name = "name" , length = 50, nullable = false)
    private String name;

    @NotNull
    @Column(name = "sex" , length = 5, nullable = false)
    private String sex;

    public Student(){

    }

    public Student(Integer id, String name, String sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
