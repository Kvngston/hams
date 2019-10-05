package com.example.hams.Service;

import com.example.hams.Domain.Student;
import com.example.hams.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public UserDetails loadUserByUsername(String regNo) throws UsernameNotFoundException {
        Student student = studentRepository.findByRegNo(regNo);
        CustomUserDetails userDetails = null;

        if (student != null) {
            userDetails = new CustomUserDetails();
            //System.out.println(user);
            userDetails.setStudent(student);
        } else {
            throw new UsernameNotFoundException("Student with Registration Number " + regNo + "does not exist");
        }

        return userDetails;
    }
}
