package com.example.emailsender.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Getter
@Setter

@Configuration
@PropertySource(value = "classpath:email.properties")
public class EmailProperties {

    @Value("smtp.gmail.com")
    private String host;
    @Value("587")
    private Integer port;

    @Value("lqdian@gmail.com")
    private String username;
    @Value("")
    private String password;
    @Value("true")
    private boolean smtAuth;
    @Value("true")
    private boolean startTLS;
}
