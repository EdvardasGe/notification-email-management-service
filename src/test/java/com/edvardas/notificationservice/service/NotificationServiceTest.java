package com.edvardas.notificationservice.service;

import static org.mockito.ArgumentCaptor.forClass;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.edvardas.notificationservice.model.Notification;
import com.edvardas.notificationservice.repository.NotificationRepository;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.time.LocalDateTime;

@ExtendWith(MockitoExtension.class)
public class NotificationServiceTest {

    @Mock
    private NotificationRepository notificationRepository;

    @Mock
    private EmailService emailService;

    @InjectMocks
    private NotificationService notificationService;

    @Test
    public void testSendNotification() {
        String recipientEmail = "test@example.com";
        String subject = "Test Subject";
        String notificationBody = "Test Body";

        notificationService.sendNotification(recipientEmail, subject, notificationBody);

        ArgumentCaptor<Notification> notificationCaptor = forClass(Notification.class);
        verify(notificationRepository, times(1)).save(notificationCaptor.capture());
        Notification savedNotification = notificationCaptor.getValue();

        assertEquals(subject, savedNotification.getSubject(), "Notification subject does not match");
        assertEquals(notificationBody, savedNotification.getNotificationBody(), "Notification body does not match");
        assertEquals(recipientEmail, savedNotification.getRecipientEmail(), "Recipient email does not match");
        assertEquals(LocalDateTime.now().getYear(), savedNotification.getSentAt().getYear(), "Notification sent time does not match");

        verify(emailService, times(1)).sendSimpleEmail(eq(recipientEmail), eq("New Notification"), eq(notificationBody));
    }
}