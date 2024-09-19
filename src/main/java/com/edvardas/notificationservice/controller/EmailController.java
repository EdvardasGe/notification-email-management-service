package com.edvardas.notificationservice.controller;

import com.edvardas.notificationservice.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send")
    public String sendEmail(@RequestParam String recipient,
                            @RequestParam String subject,
                            @RequestParam String body) {
        emailService.sendSimpleEmail(recipient, subject, body);
        return "Email sent successfully to " + recipient;
    }
}
