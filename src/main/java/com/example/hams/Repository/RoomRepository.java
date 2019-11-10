package com.example.hams.Repository;

import com.example.hams.Domain.Floor;
import com.example.hams.Domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Integer> {
    List<Room> findAllByFloor(Floor floor);
    Room findByNameAndFloor(String roomName, Floor floor);
}
