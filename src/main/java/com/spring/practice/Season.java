package com.spring.practice;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Season {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Getter
    @Setter
    int season;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "show_id")
    @Getter
    @Setter
    private Show show;



}
