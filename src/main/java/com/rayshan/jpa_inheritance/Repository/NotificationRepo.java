package com.rayshan.jpa_inheritance.Repository;

import com.rayshan.jpa_inheritance.entity.Notification;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepo extends ListCrudRepository<Notification, Long> {
}
