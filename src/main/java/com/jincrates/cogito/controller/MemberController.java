package com.jincrates.cogito.controller;

import com.jincrates.cogito.entity.Member;
import com.jincrates.cogito.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class MemberController {

    @Autowired
    private MemberService service;

    @GetMapping("/all")
    public List<Member> retrieveAllUsers() {
        return service.findAll();
    }

    @GetMapping("/{email}")
    public Member retrieveUser(@PathVariable("email") String email) {
        return service.findByEmail(email);
    }
}
