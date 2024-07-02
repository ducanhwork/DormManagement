package dev.pdanh.dormmanagement.controller;

import dev.pdanh.dormmanagement.dto.response.UserResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin")
public class AuthContentController {
    @GetMapping("/home")
    public String homePage(HttpSession session, Model model, RedirectAttributes redirectAttributes) {
        boolean check = checkIfLogin(session);
        if (check) {
            model.addAttribute("userLogin", (UserResponse) session.getAttribute("userLogin"));
            return "Frontend-Dorm/home";
        } else {
            redirectAttributes.addFlashAttribute("warning", "You are not logged in");
            return "redirect:/signin";
        }
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model, HttpSession session) {
        boolean check = checkIfLogin(session);
        if (check) {
            model.addAttribute("userLogin", (UserResponse) session.getAttribute("user"));
            return "Frontend-Dorm/dashboard";
        } else {
            model.addAttribute("warning", "You are not logged in");
            return "Frontend-Dorm/login";
        }
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
