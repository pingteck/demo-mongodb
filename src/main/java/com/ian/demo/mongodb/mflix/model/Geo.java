package com.ian.demo.mongodb.mflix.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Geo {

    private String type;
    private List<Double> coordinates;

}
