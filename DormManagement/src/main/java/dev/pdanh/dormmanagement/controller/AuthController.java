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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping("/auth")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class AuthController {
    UserService userService;
    UserMapper userMapper;
    UserRepository repository;
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
    @PostMapping("/signUp")
    public String signUpPage(Model model, @ModelAttribute("signUpRequest") UserCreateRequest request) {
        if (repository.findByUsername(request.getUsername()) != null
                || repository.findByEmail(request.getEmail()) != null) {
            model.addAttribute("error", "Username or Email was taken");
            return "Frontend-Dorm/register";
        } else {
            int date = new Date().getYear();
            int redate = request.getDob().getYear();
            int diff = -redate + date;
            boolean checkDate = diff >= 18;
            if (checkDate) {
                User userSignUp = userMapper.toUser(request);
                userSignUp.setPassword(passwordEncoder.encode(userSignUp.getPassword()));
                repository.save(userSignUp);
                return "redirect:/pages/signin";
            } else {
                model.addAttribute("error", "You are under 18 years old.");
                return "Frontend-Dorm/register";
            }
        }

    }
    @PostMapping("/login")
    public String loginUser(@ModelAttribute("signInRequest") AuthenticationRequest authenticationRequest, HttpSession session, Model model) {
        UserResponse userResponse = userService.loginUser(authenticationRequest);

        if (userResponse != null) {
            session.setAttribute("user", userResponse);
            return "redirect:/admin/home";
        } else {
            model.addAttribute("err", "Username or password incorrect");
            return "Frontend-Dorm/login";
        }
    }
    @GetMapping("/logout")
    public String logout(HttpSession session, Model model) {
        if(session.getAttribute("user") != null) {
            session.invalidate();
            return "redirect:/index";
        }else{
            model.addAttribute("warning","You are not log in");
            return "Frontend-Dorm/login";
        }
    }
}
