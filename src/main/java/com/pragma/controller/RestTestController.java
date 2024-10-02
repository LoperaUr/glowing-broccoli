package com.pragma.controller;

import com.pragma.entity.Test;
import com.pragma.service.TestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/test")
public class RestTestController {

    private final TestService testService;

    public RestTestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping(value = "/", produces = "application/json")
    public ResponseEntity<List<Test>> getAll () {
        return ResponseEntity.ok(testService.getAll());
    }
}
