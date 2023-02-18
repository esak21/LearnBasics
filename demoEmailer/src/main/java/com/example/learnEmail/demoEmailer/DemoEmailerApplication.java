package com.example.learnEmail.demoEmailer;

import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class DemoEmailerApplication {

	@Autowired
	private EmailSenderService service;
	public static void main(String[] args) {

		SpringApplication.run(DemoEmailerApplication.class, args);
	}
	@EventListener(ApplicationReadyEvent.class)
	public void triggerEmail() throws MessagingException {

		service.SendEmailWithAttachments("esakkisankart@gmail.com",
				"Hey ! Welcome to the World of Programming ",
				"New Joiner Onboarding Details",
				 "/home/esak/ChasingMyDream/LearnBasics/README.md");
	}

}
