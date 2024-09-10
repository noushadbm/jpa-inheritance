package com.rayshan.jpa_inheritance.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Data
@Entity
@Table(name = "notification")
@Inheritance(
        strategy = InheritanceType.JOINED
)
public class Notification {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(name = "created_on")
    private Date createdOn;
}
