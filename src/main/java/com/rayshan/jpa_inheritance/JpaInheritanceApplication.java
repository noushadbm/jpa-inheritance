package com.rayshan.jpa_inheritance;

import com.rayshan.jpa_inheritance.service.NotificationService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Log4j2
public class JpaInheritanceApplication implements CommandLineRunner {

	@Autowired
	private NotificationService notificationService;

	public static void main(String[] args) {
		SpringApplication.run(JpaInheritanceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info(">>>>> Starting up...");
		System.out.println(">>>>>>>>>");
		notificationService.sendCampaign("Noushad", "hello from world");
	}
}
