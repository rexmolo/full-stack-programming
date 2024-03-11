package com.example.emailsender.Service;

import com.example.emailsender.Repository.EmailRepository;
import com.example.emailsender.domain.dto.EmailDTO;
import com.example.emailsender.domain.entity.Email;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService{

    private final EmailRepository emailRepository;

    public EmailServiceImpl(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

    @Override
    public void sendEmail(EmailDTO emailDTO) {

        if (emailDTO == null) throw new IllegalArgumentException("email is null");

        Email entity = Email.builder()
                .to(emailDTO.getTo())
                .from("ddddd")
                .subject(emailDTO.getSubject())
                .content(emailDTO.getHtml())
                .build();

        emailRepository.save(entity);

    }
}
