package com.ian.demo.mongodb.mflix.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Imdb {

    private Double rating;
    private Integer votes;
    private Integer id;

}
