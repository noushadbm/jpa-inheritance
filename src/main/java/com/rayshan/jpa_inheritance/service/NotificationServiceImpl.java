package com.rayshan.jpa_inheritance.service;

import com.rayshan.jpa_inheritance.Repository.NotificationRepo;
import com.rayshan.jpa_inheritance.entity.Notification;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NotificationServiceImpl implements NotificationService{
    @Autowired
    private NotificationRepo notificationRepo;

    @Autowired
    private List<NotificationSender> notificationSenders;

    private Map<Class<? extends Notification>, NotificationSender>  notificationSenderMap = new HashMap<>();

    @PostConstruct
    public void init() {
        for(NotificationSender notificationSender: notificationSenders){
            notificationSenderMap.put(notificationSender.appliesTo(), notificationSender);
        }
    }

    @Override
    public void sendCampaign(String name, String message) {
        List<Notification> notifications = notificationRepo.findAll();
        for (Notification notification: notifications) {
            notificationSenderMap.get(notification.getClass()).send(notification);
        }
    }
}
