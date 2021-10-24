package com.jincrates.cogito.service;

import com.jincrates.cogito.dto.UserDTO;
import com.jincrates.cogito.exception.UserNotFoundException;
import com.jincrates.cogito.repository.UserRepository;
import com.jincrates.cogito.entity.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findByEmail(String email) {

        Optional<User> member = repository.findByEmail(email, false);

        if(member.isEmpty()) {
            throw  new UserNotFoundException(String.format("Email[%s] not found", email));
        }

        //Heteos
        //Resource<User> resource = new Resource<>(member.get());
        //ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).findAll());
        //resource.add(linkTo.withRel("all-users");
        //return resource

        return member.get();
    }

    /*
    public void deleteByEmail(String email) {

        Optional<User> member = repository.findByEmail(email, false);

        if(member.isEmpty()) {
            throw  new UserNotFoundException(String.format("Email[%s] not found", email));
        }

        repository.deleteByEmail(email);
    }
    */

    public User save(User user) {
        return repository.save(user);
    }
}
