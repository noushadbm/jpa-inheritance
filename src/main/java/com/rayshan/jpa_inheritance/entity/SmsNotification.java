package com.rayshan.jpa_inheritance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "sms_notification")
public class SmsNotification extends Notification{
    @Column(
            name = "phone_number",
            nullable = false
    )
    private String phoneNumber;
}
