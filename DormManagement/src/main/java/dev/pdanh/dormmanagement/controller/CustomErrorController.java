package dev.pdanh.dormmanagement.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class CustomErrorController implements ErrorController {
    @GetMapping
    public String handleError(HttpServletRequest request) {
        // Retrieve the error status code
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode != null) {
            if (statusCode == 404) {
                return "Frontend-Dorm/404"; // Return the name of the 404 error page
            } else if (statusCode == 500) {
                return "Frontend-Dorm/500"; // Return the name of the 500 error page
            }
        }

        // Default to a generic error page
        return "Frontend-Dorm/error";
    }

}
