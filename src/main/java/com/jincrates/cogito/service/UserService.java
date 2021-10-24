package com.jincrates.cogito.service;

import com.jincrates.cogito.dto.UserDTO;
import com.jincrates.cogito.entity.User;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findByEmail(String email);

    //void deleteByEmail(String email);

    User save(User user);
}
