package com.ian.demo.mongodb.mflix.repository;

import com.ian.demo.mongodb.mflix.entity.Theater;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TheaterRepository extends MongoRepository<Theater, String> {

}
