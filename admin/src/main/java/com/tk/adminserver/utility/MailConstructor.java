package com.tk.adminserver.utility;

import com.tk.adminserver.Domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class MailConstructor {

    @Autowired
    private Environment env;

    public SimpleMailMessage constructAttendedToMail(String to) {

        String message = "\nYour Complaint has been Attended to";
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(to);
        email.setSubject("Nnamdi Azikiwe Hostels");
        email.setText(message);
        email.setFrom(env.getProperty("support.email"));
        return email;

    }
}
