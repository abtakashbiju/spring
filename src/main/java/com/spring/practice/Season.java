package com.spring.practice;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "season", cascade = CascadeType.ALL)
    @JsonManagedReference
    @Setter
    @Getter
    private List<Episode> episodes;

    public List<Episode> addEpisodes(int n){
        this.episodes = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            Episode e = new Episode();
            e.setEpisode(i);
            e.setSeason(this);
            episodes.add(e);
        }
        return (episodes);
    }
}
