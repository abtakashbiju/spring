package com.spring.practice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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

    @GetMapping("/")
    public String welcomeMessage(){
        return("Welcome to the Home Page");
    }


    @PostMapping("add-episodes")
    public void addEpisodes(@RequestBody ShowDetailsRequest showDetailsRequest){

        //find the show name
        Show show = showRepository.findShowByShowName(showDetailsRequest.getName());

        //find the season
        Season season = show.getSeason().stream()
                .filter(s -> s.getSeason() == (showDetailsRequest.getSeason()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Cannot find season"));

        //make a list of episodes
        //add to the season
        season.addEpisodes(showDetailsRequest.getEpisodes());

        //add to the show
        showRepository.save(show);
        //save the show to repository
    }
}
