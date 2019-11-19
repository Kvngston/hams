package com.tk.adminserver.Controller;

import com.tk.adminserver.Domain.Student;
import com.tk.adminserver.Repository.RoomRepository;
import com.tk.adminserver.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentDetailsController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private RoomRepository roomRepository;

    @RequestMapping(value = "/viewStudentDetails", method = RequestMethod.GET)
    public String getStudentDetailsPage(Model model){

        return "StudentDetails";
    }

    @RequestMapping(value = "/checkStudent", method = RequestMethod.POST)
    public String checkStudent(@RequestParam("regNo") String regNo, Model model){

        Student student = studentRepository.findByRegNo(regNo);
        System.out.println(student);
        model.addAttribute("student", student);
        model.addAttribute("notEmpty", true);

        return "StudentDetails";
    }


}
