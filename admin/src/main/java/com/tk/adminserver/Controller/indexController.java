package com.tk.adminserver.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class indexController {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String indexPage(){

        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public String logout() {
        return "login";
    }
}
