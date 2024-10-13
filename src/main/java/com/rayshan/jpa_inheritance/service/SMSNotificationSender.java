package com.rayshan.jpa_inheritance.service;

import com.rayshan.jpa_inheritance.entity.SmsNotification;

public class SMSNotificationSender implements NotificationSender<SmsNotification> {
    @Override
    public Class<SmsNotification> appliesTo() {
        return SmsNotification.class;
    }

    @Override
    public void send(SmsNotification notification) {
        System.out.println(">>>> Sending sms to " + notification.getPhoneNumber());
    }

}
