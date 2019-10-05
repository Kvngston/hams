package com.example.hams.Repository;

import com.example.hams.Domain.Floor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FloorRepository extends JpaRepository<Floor, Integer> {
    Floor findByFloorName(String floorName);
}
