package com.example.hams.Controller;

import com.example.hams.Domain.Complaint;
import com.example.hams.Domain.Student;
import com.example.hams.Repository.ComplaintRepository;
import com.example.hams.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class ComplaintsController  {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ComplaintRepository complaintRepository;

    @RequestMapping(value = "/complaint", method = RequestMethod.GET)
    public String getComplaintPage(Model model){

        Complaint complaint = new Complaint();
        model.addAttribute("complaint", complaint);

        return "layComplaint";
    }

    @RequestMapping(value = "layComplaint", method = RequestMethod.POST)
    public String layComplaint(Principal principal, @ModelAttribute(name = "complaint") @Valid Complaint complaint,
                               @RequestParam("email") String email,
                               BindingResult bindingResult,
                               Model model){

        Student loggedInStudent = studentRepository.findByRegNo(principal.getName());

        if(bindingResult.hasErrors()){
            return "layComplaint";
        }else{
            complaint.setEmail(email);
            complaint.setStudent(loggedInStudent);
            complaint.setAttendedTo(0);
            complaintRepository.save(complaint);
        }


        return "redirect:/dashboard";
    }

}
