package com.ian.demo.mongodb.mflix.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Address {

    private String street1;
    private String city;
    private String state;
    private String zipcode;

}
