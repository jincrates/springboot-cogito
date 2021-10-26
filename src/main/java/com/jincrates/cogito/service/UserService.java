package com.jincrates.cogito.service;

import com.jincrates.cogito.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findByEmail(String email);

    //void deleteByEmail(String email);

    User save(User user);
}
