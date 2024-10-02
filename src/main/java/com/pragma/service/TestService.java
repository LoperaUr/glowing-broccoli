package com.pragma.service;

import com.pragma.entity.Test;
import com.pragma.exception.GenericRuntimeException;
import com.pragma.repository.TestRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    private final TestRepository testRepository;

    public TestService(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    public List<Test> getAll() {
        List<Test> allTests = testRepository.findAll();
        if (allTests.isEmpty()) {
            throw new GenericRuntimeException("No tests found", HttpStatus.NOT_FOUND);
        }
        return allTests;
    }
}
