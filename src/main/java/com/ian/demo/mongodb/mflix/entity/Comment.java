package com.ian.demo.mongodb.mflix.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Getter
@Setter
@ToString
@Document("comments")
public class Comment {

    public static final String F_ID = "id";
    public static final String F_NAME = "name";
    public static final String F_EMAIL = "email";
    public static final String F_MOVIE_ID = "movie_id";
    public static final String F_TEXT = "text";
    public static final String F_DATE = "date";

    @Id
    private String id;
    private String name;
    private String email;
    private String movieId;
    private String text;
    private Instant date;

}
