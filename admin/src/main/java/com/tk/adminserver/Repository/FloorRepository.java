package com.tk.adminserver.Repository;

import com.tk.adminserver.Domain.Floor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FloorRepository extends JpaRepository<Floor, Integer> {

    Floor findByFloorName(String floorName);
}
