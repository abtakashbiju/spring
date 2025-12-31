package com.spring.practice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    String name;

    @GetMapping("/")
    public String sayHello(){
        return(name);
    }

    @PostMapping("/post")
    public String addName(@RequestBody String name){
        this.name = name;
        return name;
    }

}
