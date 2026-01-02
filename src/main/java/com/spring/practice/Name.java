package com.spring.practice;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Entity
public class Name {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){ return name; }
    public int getAge(){ return age; }

    public void setAge(int age) {
        this.age = age;
    }
}
