package com.edvardas.notificationservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "notifications")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "recipient_email")
    private String recipientEmail;

    @Column(name = "subject")
    private String subject;

    @Column(name = "notification_body")
    private String notificationBody;

    @Column(name = "sent_at")
    private LocalDateTime sentAt;

    public Notification() {}

    public Notification(String recipientEmail, String subject, String notificationBody, LocalDateTime sentAt) {
        this.recipientEmail = recipientEmail;
        this.subject = subject;
        this.notificationBody = notificationBody;
        this.sentAt = sentAt;
    }

}
