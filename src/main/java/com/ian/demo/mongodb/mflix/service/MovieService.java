package com.ian.demo.mongodb.mflix.service;

import com.ian.demo.mongodb.mflix.entity.Movie;
import com.ian.demo.mongodb.mflix.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

}
