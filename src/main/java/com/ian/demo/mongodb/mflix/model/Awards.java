package com.ian.demo.mongodb.mflix.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Awards {

    private Integer wins;
    private Integer nominations;
    private String text;

}
