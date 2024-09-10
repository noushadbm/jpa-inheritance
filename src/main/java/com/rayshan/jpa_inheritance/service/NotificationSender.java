package com.rayshan.jpa_inheritance.service;

public interface NotificationSender<T> {
    Class<T> appliesTo();
    void send(T notification);
}
