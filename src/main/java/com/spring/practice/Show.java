package com.spring.practice;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Show {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Setter
    @Getter
    private String showName;


}
