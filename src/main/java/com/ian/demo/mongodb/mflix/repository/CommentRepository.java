package com.ian.demo.mongodb.mflix.repository;

import com.ian.demo.mongodb.mflix.entity.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepository extends MongoRepository<Comment, String> {

}
