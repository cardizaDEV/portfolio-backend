package com.cardiza.portfolio.service;

import com.cardiza.portfolio.dto.EmailRequestDto;

public interface EmailService {
    void sendMessage(EmailRequestDto request);
}
