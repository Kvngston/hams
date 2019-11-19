package com.tk.adminserver.Controller;

import com.tk.adminserver.Domain.Complaint;
import com.tk.adminserver.Domain.User;
import com.tk.adminserver.Repository.ComplaintRepository;
import com.tk.adminserver.utility.MailConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Controller
public class ComplaintController {

    @Autowired
    private ComplaintRepository complaintRepository;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private MailConstructor mailConstructor;

    @Autowired
    private Environment env;



    @RequestMapping(value = "/viewComplaints", method = RequestMethod.GET)
    public String getViewComplaintsPage(Model model){

        List<Complaint> complaints = complaintRepository.findAll();
        model.addAttribute("complaints", complaints);

        return "ViewComplaints";
    }

    @RequestMapping(value = "/attendedTo{id}", method = RequestMethod.GET)
    public String attendedTo(@PathVariable(name = "id") Long id, Model model){
        Optional<Complaint> complaint = complaintRepository.findById(id);

        if(complaint.isPresent()){
            if(complaint.get().getAttendedTo() == 0) {
                complaint.get().setAttendedTo(1);

                SimpleMailMessage newMail = mailConstructor.constructAttendedToMail(complaint.get().getEmail());
                mailSender.send(newMail);
                model.addAttribute("mailSent", true);

            } else {
                complaint.get().setAttendedTo(0);
            }
            complaintRepository.save(complaint.get());
        }




        return "redirect:/viewComplaints";
    }
}
