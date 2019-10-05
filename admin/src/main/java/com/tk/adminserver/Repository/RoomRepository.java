package com.tk.adminserver.Repository;

import com.tk.adminserver.Domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Integer> {
}
