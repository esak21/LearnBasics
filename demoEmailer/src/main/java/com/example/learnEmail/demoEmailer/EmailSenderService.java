package com.example.learnEmail.demoEmailer;


import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendSimpleEmail(String toEmail, String bodyMessage, String subject) {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(toEmail);
        message.setSubject(subject);
        message.setText(bodyMessage);
        message.setFrom("spring001mailer@gmail.com");

        mailSender.send(message);
        System.out.println("Mail Send .......");

    }

    public void SendEmailWithAttachments(String toEmail, String body, String subject, String Attachment) throws MessagingException {

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper  mimemessagehelper = new MimeMessageHelper(message, true);

        mimemessagehelper.setFrom("spring001mailer#gmail.com");
        mimemessagehelper.setTo(toEmail);
        mimemessagehelper.setText(body);
        mimemessagehelper.setSubject(subject);

        FileSystemResource fileSystem = new FileSystemResource( new File(Attachment));
        mimemessagehelper.addAttachment(fileSystem.getFilename(), fileSystem);

        mailSender.send(message);
        System.out.println("Email Send....");
    }
}
