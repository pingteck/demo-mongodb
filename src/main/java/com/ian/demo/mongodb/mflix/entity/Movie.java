package com.ian.demo.mongodb.mflix.entity;

import com.ian.demo.mongodb.mflix.model.Awards;
import com.ian.demo.mongodb.mflix.model.Imdb;
import com.ian.demo.mongodb.mflix.model.Tomatoes;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
@ToString
@Document("movies")
public class Movie {

    public static final String F_ID = "id";
    public static final String F_AWARDS = "awards";
    public static final String F_CAST = "cast";
    public static final String F_COUNTRIES = "countries";
    public static final String F_DIRECTORS = "directors";
    public static final String F_FULL_PLOT = "fullplot";
    public static final String F_GENRES = "genres";
    public static final String F_IMDB = "imdb";
    public static final String F_LANGUAGES = "languages";
    public static final String F_LAST_UPDATED = "lastupdated";
    public static final String F_NUM_MFLIX_COMMENTS = "num_mflix_comments";
    public static final String F_PLOT = "plot";
    public static final String F_POSTER = "poster";
    public static final String F_RATED = "rated";
    public static final String F_RELEASED = "released";
    public static final String F_RUNTIME = "runtime";
    public static final String F_TITLE = "title";
    public static final String F_TOMATOES = "tomatoes";
    public static final String F_WRITERS = "writers";
    public static final String F_YEAR = "year";
    public static final String F_TYPE = "type";

    private String id;
    private Awards awards;
    private List<String> cast;
    private List<String> countries;
    private List<String> directors;
    @Field("fullplot")
    private String fullPlot;
    private List<String> genres;
    private Imdb imdb;
    private List<String> languages;
    @Field("lastupdated")
    private String lastUpdated;
    private Integer numMflixComments;
    private String plot;
    private String poster;
    private String rated;
    private Instant released;
    private Integer runtime;
    private String title;
    private Tomatoes tomatoes;
    private List<String> writers;
    private String year;
    private String type;

}
