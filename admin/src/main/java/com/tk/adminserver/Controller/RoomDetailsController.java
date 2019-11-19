package com.tk.adminserver.Controller;

import com.tk.adminserver.Domain.Floor;
import com.tk.adminserver.Domain.Room;
import com.tk.adminserver.Domain.Student;
import com.tk.adminserver.Repository.FloorRepository;
import com.tk.adminserver.Repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;

@Controller
public class RoomDetailsController {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private FloorRepository floorRepository;

    @RequestMapping(value = "/viewRoom", method = RequestMethod.GET)
    public String getRoomDetailsPage(Model model){


        return "RoomDetails";
    }

    @RequestMapping(value = "/checkRoom", method = RequestMethod.POST)
    public String checkRoom(@RequestParam("floor") String floor, @RequestParam("roomNumber") String roomNumber, Model model){

        Floor roomFloor = floorRepository.findByFloorName(floor);
        Room room = roomRepository.findRoomByFloorAndName(roomFloor, "Room"+roomNumber);
        System.out.println(room);
        Set<Student> roomMates = room.getRoommates();
        System.out.println();

        model.addAttribute("room", room);
        model.addAttribute("roomMates", roomMates);
        model.addAttribute("notEmpty", true);

        return "RoomDetails";
    }

}
