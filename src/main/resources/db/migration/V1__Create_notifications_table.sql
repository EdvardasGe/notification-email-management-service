CREATE TABLE notifications (
                               id SERIAL PRIMARY KEY,
                               recipient_email VARCHAR(255) NOT NULL,
                               subject VARCHAR(255) NOT NULL,
                               notification_body VARCHAR(1000) NOT NULL,
                               sent_at TIMESTAMP NOT NULL
);