
package com.cardiza.portfolio.service.impl;

import com.cardiza.portfolio.dto.EmailRequestDto;
import com.cardiza.portfolio.service.EmailService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    @NonNull
    private final JavaMailSender mailSender;

    @Value("${contact.mail.to}")
    private String mailTo;

    @Override
    public void sendMessage(EmailRequestDto request) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(mailTo);
        message.setSubject("Portfolio contact: " + request.getName());
        message.setText(
                "From: " + request.getName() + " <" + request.getEmail() + ">\n\n" +
                        request.getMessage()
        );
        message.setReplyTo(request.getEmail());
        this.mailSender.send(message);
    }
}