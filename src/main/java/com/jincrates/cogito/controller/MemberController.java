package com.jincrates.cogito.controller;

import com.jincrates.cogito.entity.Member;
import com.jincrates.cogito.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
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

    /*
    @DeleteMapping("{email}")
    public void deleteUser(@PathVariable("email") String email) {
        service.deleteByEmail(email);
    }
    */

    @PostMapping("")
    public ResponseEntity<Member> createUser(@Valid @RequestBody Member member) {

        Member savedUser = service.save(member);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{email}")
                .buildAndExpand(savedUser.getEmail())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
