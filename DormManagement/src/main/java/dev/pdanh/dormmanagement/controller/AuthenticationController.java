package dev.pdanh.dormmanagement.controller;

import ch.qos.logback.core.model.Model;
import dev.pdanh.dormmanagement.dto.request.AuthenticationRequest;
import dev.pdanh.dormmanagement.dto.response.UserResponse;
import dev.pdanh.dormmanagement.mapper.UserMapper;
import dev.pdanh.dormmanagement.repository.UserRepository;
import dev.pdanh.dormmanagement.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class AuthenticationController {
    UserService userService;
    UserRepository repository;
    UserMapper userMapper;
    @GetMapping("/home")
    public String home() {
        return "Frontend-Dorm/index";
    }
    @GetMapping("/login")
    public String loginPage(){
        return "Frontend-Dorm/login";
    }

}
