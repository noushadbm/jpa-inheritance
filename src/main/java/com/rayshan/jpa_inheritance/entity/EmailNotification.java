package com.rayshan.jpa_inheritance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "email_notification")
public class EmailNotification extends Notification {
    @Column(
            name = "email_address",
            nullable = false
    )
    private String emailAddress;
}
