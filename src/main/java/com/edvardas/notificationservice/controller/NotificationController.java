package com.edvardas.notificationservice.controller;

import com.edvardas.notificationservice.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping("/send")
    public String sendNotification(@RequestParam String recipientEmail,
                                   @RequestParam String subject,
                                   @RequestParam String messageBody) {
        notificationService.sendNotification(recipientEmail, subject, messageBody);
        return "Notification sent to " + recipientEmail;
    }
}