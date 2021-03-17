package io.learning.springsecurity.web.model;


import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.Calendar;

@Data
public class User {

    private Long id;

    @NotEmpty(message = "Username is required.")
    private String username;

    @NotEmpty(message = "Email is required.")
    private String email;

    private Calendar created = Calendar.getInstance();

}