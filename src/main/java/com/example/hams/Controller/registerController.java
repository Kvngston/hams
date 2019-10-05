package com.example.hams.Controller;

import com.example.hams.Domain.Student;
import com.example.hams.Repository.RoleRepository;
import com.example.hams.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class registerController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String getRegisterPage(Model model){
        Student student = new Student();
        model.addAttribute("student", student);

        return "register";
    }

    @RequestMapping(value = "/addStudent" , method = RequestMethod.POST)
    public String addStudent(@ModelAttribute("student") @Valid Student student,
                             BindingResult bindingResult,
                             @RequestParam("confPass") String cPassword,
                             Model model){

        if(bindingResult.hasErrors()){
            System.out.println(bindingResult.getAllErrors());
            return "register";
        }else{
            if(studentRepository.findByRegNo(student.getRegNo()) == null){
                if((student.getPassword().equals(cPassword)) && !cPassword.isEmpty() && student.getAge() != 0 && student.getRegNo().length() == 10){
                    if(!(student.getPassword().equals(cPassword))){
                        model.addAttribute("passwordMismatch", true);
                    }
                    if(student.getAge() == 0){
                        model.addAttribute("incorrectAge", true);
                    }
                    if(student.getRegNo().length() != 10){
                        model.addAttribute("regNoIncorrect", true);
                    }
                    student.setPassword(passwordEncoder.encode(student.getPassword()));
                    student.setRole(roleRepository.findByRole("student"));
                    studentRepository.save(student);
                }else{
                    return "register";
                }
            }else{
                model.addAttribute("existingUser", true);
                return "register";
            }
        }


        return "index";
    }
}
