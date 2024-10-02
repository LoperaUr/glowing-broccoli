package com.pragma.controller;

import com.pragma.dto.UserDto;
import com.pragma.entity.User;
import com.pragma.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class RestUserController {

    private final UserService userService;

    public RestUserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<User> addUser(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.addUser(userDto));

    }

    @GetMapping(value = "/", produces = "application/json")
    public ResponseEntity<List<User>> getAll () {
        return ResponseEntity.ok(userService.getAll());
    }
}
