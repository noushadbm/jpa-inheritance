package com.rayshan.jpa_inheritance.Repository;

import com.rayshan.jpa_inheritance.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
