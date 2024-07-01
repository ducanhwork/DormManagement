package dev.pdanh.dormmanagement.controller;

import dev.pdanh.dormmanagement.dto.request.AuthenticationRequest;
import dev.pdanh.dormmanagement.dto.request.UserCreateRequest;
import dev.pdanh.dormmanagement.dto.response.UserResponse;
import dev.pdanh.dormmanagement.mapper.UserMapper;
import dev.pdanh.dormmanagement.model.User;
import dev.pdanh.dormmanagement.repository.UserRepository;
import dev.pdanh.dormmanagement.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("/")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ContentController {


    @GetMapping({"/index", "/"})
    public String home() {
        return "Frontend-Dorm/index";
    }

    @GetMapping("/home")
    public String homePage() {
        return "Frontend-Dorm/home";
    }

    @GetMapping("/signin")
    public String loginPage(Model model) {
        AuthenticationRequest authenticationRequest = new AuthenticationRequest();
        model.addAttribute("signInRequest", authenticationRequest);
        return "Frontend-Dorm/login";
    }



    @GetMapping("/register")
    public String signUpPage(Model model) {
        UserCreateRequest request = new UserCreateRequest();
        model.addAttribute("signUpRequest", request);
        return "Frontend-Dorm/register";
    }


}
