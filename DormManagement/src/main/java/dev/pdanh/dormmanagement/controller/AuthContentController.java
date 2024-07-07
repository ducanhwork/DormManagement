package dev.pdanh.dormmanagement.controller;

import dev.pdanh.dormmanagement.dto.request.DormCreateRequest;
import dev.pdanh.dormmanagement.dto.response.UserResponse;
import dev.pdanh.dormmanagement.mapper.UserMapper;
import dev.pdanh.dormmanagement.model.Dorm;
import dev.pdanh.dormmanagement.model.User;
import dev.pdanh.dormmanagement.repository.DormRepository;
import dev.pdanh.dormmanagement.service.DormService;
import jakarta.servlet.http.HttpSession;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class AuthContentController {
    DormRepository dormRepository;
    DormService dormService;
    private final UserMapper userMapper;

    @GetMapping("/home")
    public String homePage(HttpSession session, Model model, RedirectAttributes redirectAttributes) {
        boolean check = checkIfLogin(session);
        if (check) {
            return "Frontend-Dorm/home";
        } else {
            redirectAttributes.addFlashAttribute("warning", "You are not logged in");
            return "redirect:/signin";
        }
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model, HttpSession session) {
        DormCreateRequest request = new DormCreateRequest();
        boolean check = checkIfLogin(session);
        if (check) {
            User user = userMapper.toUser((UserResponse) session.getAttribute("user"));
            List<Dorm> dorms = dormService.getAll(user);
            if (dorms.isEmpty()) {
                model.addAttribute("noticedorm", "You do not have any dorm ...");
            } else {
                model.addAttribute("listDorm", dorms);
            }
            model.addAttribute("dormCreateRequest", request);
            return "Frontend-Dorm/dashboard";
        } else {
            model.addAttribute("warning", "You are not logged in");
            return "Frontend-Dorm/login";
        }
    }

    @GetMapping("/manage")
    public String managePage(Model model, HttpSession session) {
        DormCreateRequest request = new DormCreateRequest();
        boolean check = checkIfLogin(session);
        if (check) {
            User user = userMapper.toUser((UserResponse) session.getAttribute("user"));
            List<Dorm> dorms = dormService.getAll(user);
            if (dorms.isEmpty()) {
                model.addAttribute("noticedorm", "You do not have any dorm ...");
            } else {
                model.addAttribute("listDorm", dorms);
            }
            model.addAttribute("dormCreateRequest", request);
            return "Frontend-Dorm/manage";
        } else {
            model.addAttribute("warning", "You are not logged in");
            return "Frontend-Dorm/login";
        }
    }
    @GetMapping("/service")
    public String servie(Model model, HttpSession session) {
        return "Frontend-Dorm/service";
    }
    @GetMapping("/infor")
    public String information(HttpSession session, Model model, RedirectAttributes redirectAttributes) {
        if (checkIfLogin(session)) {
            model.addAttribute("userLogin", (UserResponse) session.getAttribute("user"));
            return "Frontend-Dorm/information";
        } else {
            redirectAttributes.addFlashAttribute("warning", "You are not logged in");
            return "redirect:/signin";
        }
    }
    @GetMapping("/payment")
    public String payment(Model model, HttpSession session, RedirectAttributes redirectAttributes) {
        return "Frontend-Dorm/payment";
    }
    //REUSABLE FUNCTION
    public boolean checkIfLogin(HttpSession session) {
        if (session.getAttribute("user") != null) {
            System.out.println();
            return true;
        }
        return false;
    }
}
