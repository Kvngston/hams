package com.tk.adminserver.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DashboardController {

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String getDashboardPage(Model model){

        return "dashboard";
    }
}
