package com.riwi.multimedia.management.infrastructure.helpers;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.stream.Collectors;

import org.springframework.http.MediaType;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class EmailHelper {
    private final JavaMailSender mailSender;

    public void sendMail(String mail, String user, Date date) {
        MimeMessage message = mailSender.createMimeMessage();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String dateAppointment = formatter.format(date.toInstant().atZone(ZoneId.systemDefault()));

        String htmlContent = this.readHTMLTemplate(mail, user, dateAppointment);

        try {
            message.setFrom(new InternetAddress("juanse.fermon@gmail.com"));
            message.setSubject("class added successfully to user");

            message.setRecipients(MimeMessage.RecipientType.TO, mail);
            message.setContent(htmlContent, MediaType.TEXT_HTML_VALUE);

            mailSender.send(message);
            System.out.println("Email sended successfully");

        } catch (Exception e) {
            System.out.println("ERROR => Email could not be sent " + e.getMessage());

        }
    }

    private String readHTMLTemplate(String nameClient, String nameEmployee, String date) {
        
        final Path path = Paths.get("src/main/resources/emails/email.html");

        try (var lines = Files.lines(path)) {
            var html = lines.collect(Collectors.joining());

            return html.replace("{name}", nameClient).replace("{employee}", nameEmployee).replace("{date}", date);
        } catch (IOException e) {
            System.out.println("No se pudo leer el html");
            throw new RuntimeException();
        }
    }
}