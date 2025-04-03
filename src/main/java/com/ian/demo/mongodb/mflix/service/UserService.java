package com.ian.demo.mongodb.mflix.service;

import com.ian.demo.mongodb.mflix.entity.User;
import com.ian.demo.mongodb.mflix.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

}
