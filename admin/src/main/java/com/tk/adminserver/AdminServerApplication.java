package com.tk.adminserver;

import com.tk.adminserver.Domain.Floor;
import com.tk.adminserver.Domain.Role;
import com.tk.adminserver.Domain.Room;
import com.tk.adminserver.Domain.User;
import com.tk.adminserver.Repository.FloorRepository;
import com.tk.adminserver.Repository.RoleRepository;
import com.tk.adminserver.Repository.RoomRepository;
import com.tk.adminserver.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class AdminServerApplication implements CommandLineRunner {

    @Autowired
    public RoleRepository roleRepository;

    @Autowired
    public UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private FloorRepository floorRepository;

    @Autowired
    private RoomRepository roomRepository;

    public static void main(String[] args) {
        SpringApplication.run(AdminServerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Role admin = new Role("admin");
        roleRepository.save(admin);

        Role student = new Role("student");
        roleRepository.save(student);

        User user = new User();
        user.setEmail("tochukwuchinedu21@gmail.com");
        user.setUserName("kvngston");
        user.setPassword(passwordEncoder.encode("currency1234"));
        user.setRole(roleRepository.findByRole("admin"));

        userRepository.save(user);


        Floor floor = new Floor();
        floor.setFloorName("Ground Floor");
        floorRepository.save(floor);

        Floor floor2 = new Floor();
        floor2.setFloorName("First Floor");
        floorRepository.save(floor2);

        Floor floor3 = new Floor();
        floor3.setFloorName("Second Floor");
        floorRepository.save(floor3);

        for(int i = 0; i < 42; i++){
            Room room = new Room();
            room.setName("Room "+ (i+1));
            room.setFloor(floorRepository.findByFloorName("Ground Floor"));
            roomRepository.save(room);
        }

        for(int i = 0; i < 42; i++){
            Room room = new Room();
            room.setName("Room "+ (i+1));
            room.setFloor(floor2);
            roomRepository.save(room);
        }

        for(int i = 0; i < 14; i++){
            Room room = new Room();
            room.setName("Room "+ (i+1));
            room.setFloor(floor3);
            roomRepository.save(room);
        }

    }
}
