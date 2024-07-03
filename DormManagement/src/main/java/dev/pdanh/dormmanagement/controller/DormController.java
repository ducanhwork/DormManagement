package dev.pdanh.dormmanagement.controller;

import dev.pdanh.dormmanagement.dto.request.DormCreateRequest;
import dev.pdanh.dormmanagement.dto.response.UserResponse;
import dev.pdanh.dormmanagement.mapper.UserMapper;
import dev.pdanh.dormmanagement.model.User;
import dev.pdanh.dormmanagement.repository.DormRepository;
import dev.pdanh.dormmanagement.service.DormService;
import jakarta.servlet.http.HttpSession;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dorm")
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
@RequiredArgsConstructor
public class DormController {
    DormRepository dormRepository;
    DormService dormService;
    UserMapper userMapper;

    @PostMapping("/create")
    public String createDorm(@ModelAttribute("dormCreateRequest")DormCreateRequest request, Model model, HttpSession session){
        User user = userMapper.toUser((UserResponse) session.getAttribute("user"));
        request.setUser(user);
         dormService.createDorm(request);
        return "redirect:/admin/dashboard";
    }

}
