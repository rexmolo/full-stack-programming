package com.example.emailsender.Service;

import com.example.emailsender.Exception.EmailException;
import com.example.emailsender.Repository.EmailRepository;
import com.example.emailsender.config.EmailProperties;
import com.example.emailsender.domain.dto.EmailDTO;
import com.example.emailsender.domain.entity.Email;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService{

    private final EmailRepository emailRepository;
    private final EmailProperties emailProperties;
    private final JavaMailSender javaMailSender;

    @Autowired
    public EmailServiceImpl(EmailRepository emailRepository, EmailProperties emailProperties, JavaMailSender javaMailSender) {
        this.emailRepository = emailRepository;
        this.emailProperties = emailProperties;
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void sendEmail(EmailDTO emailDTO) {

        if (emailDTO == null) throw new IllegalArgumentException("email is null");

        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false, "utf-8");

            mimeMessage.setContent(emailDTO.getHtml(), "text/html");
            helper.setTo(emailDTO.getTo());
            helper.setFrom(emailProperties.getUsername());
            helper.setSubject(emailDTO.getSubject());

            Email entity = Email.builder()
                    .to(emailDTO.getTo())
                    .from(emailProperties.getUsername())
                    .subject(emailDTO.getSubject())
                    .content(emailDTO.getHtml())
                    .build();

            emailRepository.save(entity);

            javaMailSender.send(mimeMessage);

        }catch (MessagingException e) {
            throw new EmailException("Error sending email: " + e.getMessage(), e);
        }
    }
}
