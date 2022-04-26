package com.can.springbootoracledb.controller;


import com.can.springbootoracledb.model.User;
import com.can.springbootoracledb.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping
    public List<User> findAllUser(){
        return userService.findAllUser();
    }

    @GetMapping("{id}")
    public User findUserById(@PathVariable("id") Integer id){
        return userService.findUserById(id);
    }

    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }
}
