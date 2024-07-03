package com.user.service.UserService.impl;

import com.user.service.UserService.entities.User;
import com.user.service.UserService.exception.ResourceNotFoundException;
import com.user.service.UserService.repository.UserRepository;
import com.user.service.UserService.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public User saveUser(User user) {
        //generate Unique id
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("Resource not found on server with user: " + userId));
        //fetch rating of the above user.
        //http://localhost:8083/ratings/users/c4b3e545-f1a5-4d44-972b-2f504a0f11f6
        ArrayList rating = restTemplate.getForObject("http://localhost:8083/ratings/users/"+userId, ArrayList.class);
        logger.info("{}",rating);
        user.setRatings(rating);

        return user;
    }

    @Override
    public User deleteUser(String userId) {
        return null;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }
}
