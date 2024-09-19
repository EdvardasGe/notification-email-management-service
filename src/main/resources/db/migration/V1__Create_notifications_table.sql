CREATE TABLE notifications (
                               id SERIAL PRIMARY KEY,
                               message_body VARCHAR(1000) NOT NULL,
                               recipient_email VARCHAR(255) NOT NULL,
                               sent_at TIMESTAMP NOT NULL
);