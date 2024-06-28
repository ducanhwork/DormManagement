package dev.pdanh.dormmanagement.controller;

import dev.pdanh.dormmanagement.mail.Mail;
import dev.pdanh.dormmanagement.service.MailSenderService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/mail")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class MailController {
    MailSenderService mailSenderService;
//    @PostMapping
//    public Mail sendMail(@RequestBody Mail mail) {
//
//        return
//    }
}
