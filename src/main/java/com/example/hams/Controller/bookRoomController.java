package com.example.hams.Controller;

import com.example.hams.Domain.BookingDetails;
import com.example.hams.Domain.Floor;
import com.example.hams.Domain.Room;
import com.example.hams.Domain.Student;
import com.example.hams.Repository.FloorRepository;
import com.example.hams.Repository.RoomRepository;
import com.example.hams.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class bookRoomController {


    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private FloorRepository floorRepository;

    @Autowired
    private RoomRepository roomRepository;

    @RequestMapping(value = "/bookRoom", method = RequestMethod.GET)
    public String getBookRoomPage(Principal principal, Model model){

        BookingDetails bookingDetails = new BookingDetails();

        Student loggedInStudent = studentRepository.findByRegNo(principal.getName());
        List<Floor> floorsList = floorRepository.findAll();
        List<Room> rooms = roomRepository.findAllByFloor(loggedInStudent.getFloor());
        System.out.println(floorsList);

        model.addAttribute("bookingDetails",bookingDetails);
        model.addAttribute("student", loggedInStudent);
        model.addAttribute("floorsList",floorsList);
        model.addAttribute("rooms", rooms);
        model.addAttribute("completed", false);
        return "bookRoom";
    }


    @RequestMapping(value = "/book", method = RequestMethod.POST)
    public String selectRoom(Principal principal, @RequestParam("confirmedFloor")  String confirmedFloor,@RequestParam("confirmedRoom")  String confirmedRoom,  Model model){

        Set<Student> roomates = new HashSet<>();

        System.out.println("this is the confirmed floor"+ confirmedFloor);
        System.out.println("this is the confirmed floor"+ confirmedRoom);

        Student loggedInStudent = studentRepository.findByRegNo(principal.getName());
        loggedInStudent.setFloor(floorRepository.findByFloorName(confirmedFloor));
        loggedInStudent.setRoom(roomRepository.findByNameAndFloor(confirmedRoom, loggedInStudent.getFloor()));
        loggedInStudent.setRoomNumber(confirmedRoom);

        if(loggedInStudent.getRoom().getRoommates().size() < 5) {
            roomates.add(loggedInStudent);
            loggedInStudent.getRoom().setRoommates(roomates);
        }




        studentRepository.save(loggedInStudent);
        System.out.println(loggedInStudent);
        return "redirect:/dashboard";
    }
}
