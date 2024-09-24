package com.edvardas.notificationservice.service;

import com.edvardas.notificationservice.model.Notification;
import com.edvardas.notificationservice.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private EmailService emailService;

    public void sendNotification(String recipientEmail, String subject, String notificationBody) {
        Notification notification = new Notification(recipientEmail, subject, notificationBody, LocalDateTime.now());
        notificationRepository.save(notification);

        emailService.sendSimpleEmail(recipientEmail, "New Notification", notificationBody);
    }
}
