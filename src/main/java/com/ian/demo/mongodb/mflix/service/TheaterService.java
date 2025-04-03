package com.ian.demo.mongodb.mflix.service;

import com.ian.demo.mongodb.mflix.entity.Theater;
import com.ian.demo.mongodb.mflix.repository.TheaterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TheaterService {

    private final TheaterRepository theaterRepository;

    public List<Theater> getTheaters() {
        return theaterRepository.findAll();
    }

}
