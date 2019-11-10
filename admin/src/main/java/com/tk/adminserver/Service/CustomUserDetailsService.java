package com.tk.adminserver.Service;

import com.tk.adminserver.Domain.User;
import com.tk.adminserver.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    private String  emailRegex = "[a-zA-Z0-9]{2,}@[a-zA-Z]{2,}.com";

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        System.out.println(user);
        CustomUserDetails userDetails;

        if (user != null) {
            userDetails = new CustomUserDetails();
            System.out.println(user);
            userDetails.setUser(user);
        } else {
            throw new UsernameNotFoundException("User with email " + email + "does not exist");
        }

        return userDetails;
    }
}
