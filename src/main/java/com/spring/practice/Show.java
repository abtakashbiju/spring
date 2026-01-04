package com.spring.practice;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Show {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Setter
    @Getter
    private String showName;

    @Setter
    @Getter
    private int seasons;

    @OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
    @JsonManagedReference
    @Getter
    @Setter
    List<Season> season;

    public List<Season> addSeasons(int n){
        List<Season> season = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            Season s = new Season();
            s.setSeason(i);
            s.setShow(this);
            season.add(s);
        }
        return(season);

    }
}
