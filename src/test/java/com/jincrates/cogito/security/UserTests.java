package com.jincrates.cogito.security;

import com.jincrates.cogito.entity.User;
import com.jincrates.cogito.entity.UserRole;
import com.jincrates.cogito.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.stream.IntStream;

@SpringBootTest
public class UserTests {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void insertDummies() {
        //1 - 80까지는 USER만 지정
        //81 - 90까지는 USER, MANAGER
        //91 - 100까지는 USER, MANAGER, ADMIN
        IntStream.rangeClosed(1, 100).forEach(i -> {
            User user = User.builder()
                    .email("user" + i + "@cogito.com")
                    .name("사용자" + i)
                    .fromSocial(false)
                    .password(passwordEncoder.encode("1111"))
                    .build();
            //default role
            user.addUserRole(UserRole.USER);

            if( i > 80) {
                user.addUserRole(UserRole.MANAGER);
            }

            if (i > 90) {
                user.addUserRole(UserRole.ADMIN);
            }

            repository.save(user);
        });
    }
}
