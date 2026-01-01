package com.spring.practice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class Controller {

    public final NameRepository nameRepository;

    public Controller(NameRepository nameRepository){
        this.nameRepository = nameRepository;
    }

    @GetMapping("/")
    public List<Name> sayHello(){
        return(nameRepository.findAll());
    }

    @PostMapping("/post")
    public void addName(@RequestBody String x){
        Name name = new Name();
        name.setName(x);
        nameRepository.save(name);
    }

}
