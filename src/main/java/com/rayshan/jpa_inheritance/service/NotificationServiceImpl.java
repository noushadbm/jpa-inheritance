package com.rayshan.jpa_inheritance.service;

import com.rayshan.jpa_inheritance.Repository.NotificationRepo;
import com.rayshan.jpa_inheritance.entity.EmailNotification;
import com.rayshan.jpa_inheritance.entity.Notification;
import com.rayshan.jpa_inheritance.entity.SmsNotification;
import jakarta.annotation.PostConstruct;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Log4j2
public class NotificationServiceImpl implements NotificationService{
    @Autowired
    private NotificationRepo notificationRepo;

    @Autowired
    private List<NotificationSender> notificationSenders;

    private Map<Class<? extends Notification>, NotificationSender>  notificationSenderMap = new HashMap<>();

    @PostConstruct
    public void init() {
        log.info(">>>>> Initializing....: {}", notificationSenders);
        for(NotificationSender notificationSender: notificationSenders){
            notificationSenderMap.put(notificationSender.appliesTo(), notificationSender);
        }
    }

    @Override
    public void sendCampaign(String name, String message) {
        //List<Notification> notifications = notificationRepo.findAll();
        List<Notification> notifications = new ArrayList<>();
        EmailNotification test = new EmailNotification();
        test.setId(1l);
        test.setFirstName("First");
        test.setLastName("Last");
        test.setCreatedOn(new Date());
        test.setEmailAddress("xxxxxxxx");
        notifications.add(test);
        for (Notification notification: notifications) {
            notificationSenderMap.get(notification.getClass()).send(notification);
        }
    }
}
