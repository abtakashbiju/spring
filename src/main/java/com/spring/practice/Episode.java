package com.spring.practice;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Episode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    private int episode;

    @ManyToOne
    @JsonBackReference
    @Getter
    @Setter
    @JoinColumn(name = "season_id")
    private Season season;
}
