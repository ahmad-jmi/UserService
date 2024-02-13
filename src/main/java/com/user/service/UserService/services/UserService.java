package com.user.service.UserService.services;

import com.user.service.UserService.entities.User;

import java.util.List;

public interface UserService {

    //user operations

    //create
    User saveUser(User user);

    //get All user
    List<User> getAllUsers();

    //get Single user of given Id
    User getUser(String userId);

    //delete an user
    User deleteUser(String userId);

    //update an user
    User updateUser(User user);
}
