package com.example.emailsender.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

public class EmailDTO {

    @NotBlank(message = "To field cannot blank")
    @Email(message = "this field should be a valid email")
    private String to;
    @NotBlank(message = "Subject field cannot blank")
    private String subject;

    @NotBlank(message = "Subject field cannot blank")
    private String html;

}
