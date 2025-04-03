package com.ian.demo.mongodb.mflix.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Location {

    private Address address;
    private Geo geo;

}
