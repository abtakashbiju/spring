package com.spring.practice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class Controller {

    public final ShowRepository showRepository;

    public Controller(ShowRepository showRepository){
        this.showRepository = showRepository;
    }

    @PostMapping("/addShow")
    public String addShow(@RequestBody Show send){
        showRepository.save(send);
        return("Show added " + send.getShowName());
    }

    @GetMapping("/availableShows")
    public List<Show> getAllShows(){
        return(showRepository.findAll());
    }

}
