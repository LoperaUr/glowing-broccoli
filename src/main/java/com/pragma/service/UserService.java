package com.pragma.service;

import com.pragma.dto.UserDto;
import com.pragma.entity.Test;
import com.pragma.entity.User;
import com.pragma.exception.GenericRuntimeException;
import com.pragma.repository.TestRepository;
import com.pragma.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final TestRepository testRepository;

    public UserService(UserRepository userRepository, TestRepository testRepository) {
        this.userRepository = userRepository;
        this.testRepository = testRepository;
    }

    @Transactional
    public User addUser(UserDto userDto) {
        log.info("Adding user: {}", userDto);
        User entity = userDtoToUserEntity(userDto);
        User save = userRepository.save(entity);
        log.info("User added: {}", save);
        testTest(userDto.getFirstName(), 25);
        if (userDto.isMinor()) {
            throw new GenericRuntimeException("User is minor", HttpStatus.BAD_REQUEST);
        }
        return save;
    }

    public User userDtoToUserEntity(UserDto userDto) {
        User userResult = new User();
        userResult.setFirstName(userDto.getFirstName());
        userResult.setLastName(userDto.getLastName());
        return userResult;
    }

    public void testTest(String value, int quantity) {
        Test test;
        for (int i = 0; i < quantity + 1; i++) {
            test = new Test();
            test.setValue(value + i);
            testRepository.save(test);
        }
    }

    public List<User> getAll() {
        List<User> allUsers = userRepository.findAll();
        if (allUsers.isEmpty())
            throw new GenericRuntimeException("No users found", HttpStatus.NOT_FOUND);
        return allUsers;
    }
}
