package com.jincrates.cogito.controller;

import com.jincrates.cogito.dto.BoardDTO;
import com.jincrates.cogito.dto.ReplyDTO;
import com.jincrates.cogito.dto.UserDTO;
import com.jincrates.cogito.entity.User;
import com.jincrates.cogito.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/user") @Api(tags = {"사용자 API"})
public class UserController {

    @Autowired
    private UserService service;

    @ApiOperation(value = "전체 사용자 조회")
    @GetMapping("")
    public List<User> getListAllUsers() {
        return service.findAll();
    }

    @ApiOperation(value = "사용자 조회")
    @GetMapping("/{email}")
    public User findByEmail(@PathVariable("email") String email) {
        return service.findByEmail(email);
    }

    @ApiOperation(value = "사용자 등록", response = UserDTO.class)
    @PostMapping("")
    public ResponseEntity<UserDTO> register(@Valid @RequestBody User user) {

        User savedUser = service.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{email}")
                .buildAndExpand(savedUser.getEmail())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    /*
    @DeleteMapping("{email}")
    public void deleteUser(@PathVariable("email") String email) {
        service.deleteByEmail(email);
    }
    */

}
