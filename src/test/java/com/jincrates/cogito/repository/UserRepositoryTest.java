package com.jincrates.cogito.repository;

import com.jincrates.cogito.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void insertMember() {

        IntStream.rangeClosed(1, 100).forEach(i -> {

            User user = User.builder()
                    .email("user" + i + "@cogito.com")
                    .password("1111")
                    .name("USER" + i)
                    .build();

            userRepository.save(user);
        });

    }
}