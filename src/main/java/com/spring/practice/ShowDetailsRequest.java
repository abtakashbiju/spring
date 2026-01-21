package com.spring.practice;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ShowDetailsRequest {

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private int season;

    @Getter
    @Setter
    private int episodes;
}
