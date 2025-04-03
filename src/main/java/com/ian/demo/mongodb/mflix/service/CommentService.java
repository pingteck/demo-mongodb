package com.ian.demo.mongodb.mflix.service;

import com.ian.demo.mongodb.mflix.entity.Comment;
import com.ian.demo.mongodb.mflix.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public List<Comment> getComments() {
        return commentRepository.findAll();
    }

}
