package dev.pdanh.dormmanagement.controller;

import dev.pdanh.dormmanagement.dto.request.UserCreateRequest;
import dev.pdanh.dormmanagement.dto.request.UserUpdateRequest;
import dev.pdanh.dormmanagement.mapper.UserMapper;
import dev.pdanh.dormmanagement.model.User;
import dev.pdanh.dormmanagement.repository.UserRepository;
import dev.pdanh.dormmanagement.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Slf4j
public class UserController {
    UserService userService;
    UserRepository repository;
    UserMapper userMapper;
    private final UserRepository userRepository;



//    @PostMapping("/update")
//    public String updateUser(@RequestParam UserUpdateRequest request) {
//
//    }

}
