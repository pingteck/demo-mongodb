package com.ian.demo.mongodb.mflix.repository;

import com.ian.demo.mongodb.mflix.entity.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieRepository extends MongoRepository<Movie, String> {

}
