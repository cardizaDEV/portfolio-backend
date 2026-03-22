package com.cardiza.portfolio.controller;

import com.cardiza.portfolio.dto.EmailRequestDto;
import com.cardiza.portfolio.service.EmailService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.cardiza.portfolio.config.ControllerNamings.CONTACT;

@RestController
@RequestMapping(CONTACT)
@RequiredArgsConstructor
public class EmailController {

    @NonNull
    private final EmailService emailService;

    @PostMapping
    public ResponseEntity<Void> sendMessage(@RequestBody EmailRequestDto request) {
        this.emailService.sendMessage(request);
        return ResponseEntity.ok().build();
    }
}