package com.spring.practice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class Controller {

    private ShowRepository showRepository;

    public Controller(ShowRepository showRepository){
        this.showRepository = showRepository;
    }

    @PostMapping("/post")
    public void addShow(@RequestBody Show show){
        Show s = new Show();
        s = show;
        s.setSeason(s.addSeasons(s.getSeasons()));

        showRepository.save(s);
    }

    @GetMapping("/get")
    public List<Show> getShows(){
        return(showRepository.findAll());
    }
}
