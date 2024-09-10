package com.rayshan.jpa_inheritance.service;

import com.rayshan.jpa_inheritance.entity.EmailNotification;
import jakarta.persistence.Column;
import org.springframework.stereotype.Component;

@Component
public class EmailNotificationSender implements NotificationSender<EmailNotification>{
    @Override
    public Class<EmailNotification> appliesTo() {
        return EmailNotification.class;
    }

    @Override
    public void send(EmailNotification notification) {
        System.out.println(">>>> Sending email to " + notification.getEmailAddress());
    }
}
