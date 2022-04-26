package com.can.springbootoracledb.service;

import com.can.springbootoracledb.model.User;
import com.can.springbootoracledb.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<User> findAllUser() {
        return userRepository.findAll();

    }

    @Override
    public User findUserById(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found"));
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
