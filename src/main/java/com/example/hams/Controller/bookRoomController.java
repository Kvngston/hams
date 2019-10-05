package com.example.hams.Controller;

import com.example.hams.Domain.Floor;
import com.example.hams.Domain.Student;
import com.example.hams.Repository.FloorRepository;
import com.example.hams.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.List;

@Controller
public class bookRoomController {


    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private FloorRepository floorRepository;

    @RequestMapping(value = "/bookRoom", method = RequestMethod.GET)
    public String getBookRoomPage(Principal principal, Model model){

        Student loggedInStudent = studentRepository.findByRegNo(principal.getName());
        List<Floor> floors = floorRepository.findAll();

        model.addAttribute("student", loggedInStudent);
        model.addAttribute("floors",floors);
        return "bookRoom";
    }
}
