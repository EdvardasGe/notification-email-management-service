package com.edvardas.notificationservice.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
public class EmailServiceTest {

    @Mock
    private JavaMailSender javaMailSender;

    @InjectMocks
    private EmailService emailService;

    @BeforeEach
    public void setUp() {
        reset(javaMailSender);
    }

    @Test
    public void testSendSimpleEmail() {
        String recipient = "test@example.com";
        String subject = "Test Subject";
        String body = "Test Body";

        emailService.sendSimpleEmail(recipient, subject, body);

        ArgumentCaptor<SimpleMailMessage> messageCaptor = ArgumentCaptor.forClass(SimpleMailMessage.class);
        verify(javaMailSender, times(1)).send(messageCaptor.capture());

        SimpleMailMessage sentEmail = messageCaptor.getValue();

        SimpleMailMessage expectedEmail = new SimpleMailMessage();
        expectedEmail.setTo(recipient);
        expectedEmail.setSubject(subject);
        expectedEmail.setText(body);

        assertEquals(expectedEmail, sentEmail, "Messages do not match");
        assertEquals(expectedEmail.getTo()[0], sentEmail.getTo()[0], "Recipient email does not match");
        assertEquals(expectedEmail.getSubject(), sentEmail.getSubject(), "Email subject does not match");
        assertEquals(expectedEmail.getText(), sentEmail.getText(), "Email body does not match");

    }
}