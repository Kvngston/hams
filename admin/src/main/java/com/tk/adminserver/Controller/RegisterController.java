package com.tk.adminserver.Controller;

import com.tk.adminserver.Domain.User;
import com.tk.adminserver.Repository.RoleRepository;
import com.tk.adminserver.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String getRegisterPage(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addAdmin(@ModelAttribute(name = "user") @Validated User user,
                           BindingResult bindingResult,
                           @RequestParam("confPass") String confPass,
                           Model model){


        if(bindingResult.hasErrors()){
            return "register";
        }else{
            if(userRepository.findByEmail(user.getEmail()) != null){
                model.addAttribute("userExist", true);
                return "register";
            }
            if(user.getPassword().equals(confPass)){
                user.setPassword(passwordEncoder.encode(user.getPassword()));
                user.setRole(roleRepository.findByRole("admin"));
                userRepository.save(user);
            }
        }


        return "dashboard";
    }
}
