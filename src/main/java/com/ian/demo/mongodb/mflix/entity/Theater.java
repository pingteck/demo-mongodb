package com.ian.demo.mongodb.mflix.entity;

import com.ian.demo.mongodb.mflix.model.Location;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@Document("theaters")
public class Theater {

    public static final String F_ID = "id";
    public static final String F_LOCATION = "location";
    public static final String F_THEATER_ID = "theaterId";

    @Id
    private String id;
    private Location location;
    private Integer theaterId;

}
