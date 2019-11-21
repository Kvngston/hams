package com.tk.adminserver.Controller;

import com.tk.adminserver.Domain.Floor;
import com.tk.adminserver.Domain.Student;
import com.tk.adminserver.Repository.FloorRepository;
import com.tk.adminserver.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class FloorDetailsController {

    @Autowired
    private FloorRepository floorRepository;

    @Autowired
    private StudentRepository studentRepository;

    @RequestMapping(value = "/viewFloorDetails", method = RequestMethod.GET)
    public String getFloorDetailsPage(Model model){

        return "ViewFloorDetails";
    }

    @RequestMapping(value = "/checkFloor", method = RequestMethod.POST)
    public String checkFloor(@RequestParam("floor") String floor, Model model){

        Floor mainFloor = floorRepository.findByFloorName(floor);
        List<Student> studentsOfFloor = studentRepository.findAllByFloor(mainFloor);

        model.addAttribute("studentsOfFloor", studentsOfFloor);
        model.addAttribute("noOfFloorMates", studentsOfFloor.size());
        model.addAttribute("notEmpty", true);
        return "ViewFloorDetails";
    }
}
