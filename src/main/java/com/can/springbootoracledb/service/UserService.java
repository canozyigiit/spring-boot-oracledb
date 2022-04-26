package com.can.springbootoracledb.service;

import com.can.springbootoracledb.model.User;

import java.util.List;

public interface UserService {


    List<User> findAllUser();
    User findUserById(Integer id);
    User saveUser(User user);
}
