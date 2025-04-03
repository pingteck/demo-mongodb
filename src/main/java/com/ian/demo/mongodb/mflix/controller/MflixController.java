package com.ian.demo.mongodb.mflix.controller;

import com.ian.demo.mongodb.mflix.entity.Comment;
import com.ian.demo.mongodb.mflix.entity.Movie;
import com.ian.demo.mongodb.mflix.entity.Theater;
import com.ian.demo.mongodb.mflix.entity.User;
import com.ian.demo.mongodb.mflix.service.CommentService;
import com.ian.demo.mongodb.mflix.service.MovieService;
import com.ian.demo.mongodb.mflix.service.TheaterService;
import com.ian.demo.mongodb.mflix.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/mflix/v1")
@RequiredArgsConstructor
public class MflixController {

    private final CommentService commentService;
    private final UserService userService;
    private final TheaterService theaterService;
    private final MovieService movieService;

    @GetMapping("/comments")
    public ResponseEntity<List<Comment>> getComments() {
        return ResponseEntity.ok(commentService.getComments());
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

    @GetMapping("/theaters")
    public ResponseEntity<List<Theater>> getTheaters() {
        return ResponseEntity.ok(theaterService.getTheaters());
    }

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getMovies() {
        return ResponseEntity.ok(movieService.getMovies());
    }

}
