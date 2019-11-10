package com.example.hams.Controller;

import com.example.hams.Domain.Student;
import com.example.hams.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class dashboardController {

    @Autowired
    private StudentRepository studentRepository;

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String dashboardPage(Principal principal, Model model){

        Student loggedInStudent = studentRepository.findByRegNo(principal.getName());

        if(loggedInStudent.getRoomNumber() == null){
            model.addAttribute("booked",false);
        }else{
            model.addAttribute("booked", true);
        }

        model.addAttribute("student", loggedInStudent);
        return "dashboard";
    }

}

