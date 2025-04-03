package com.ian.demo.mongodb.mflix.repository;

import com.ian.demo.mongodb.mflix.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

}
