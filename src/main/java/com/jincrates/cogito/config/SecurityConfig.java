package com.jincrates.cogito.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@Log4j2
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    //localhost:8080/login
    //id: user
    //pw: Using generated security password: "@"

    @Bean
    PasswordEncoder passwordEncoder() {
        //BCryptPasswordEncoder: bcrypt라는 해시 함수를 이용해서 패스워드를 암호화하는 목적으로 설계된 클래스
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("*").permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        //사용자 계정은 user1
        auth.inMemoryAuthentication().withUser("user1")
                .password("$2a$10$IJqlyllQgWyv3G3EmxS/o.eBXYrT4W3NK2usZGygbhY4bKH67FCaK")
                .roles("USER");
    }
}
