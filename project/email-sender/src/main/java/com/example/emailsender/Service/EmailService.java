package com.example.emailsender.Service;

import com.example.emailsender.domain.dto.EmailDTO;
import org.springframework.stereotype.Service;

@Service
public interface EmailService {
    void sendEmail(EmailDTO emailDTO);
}
