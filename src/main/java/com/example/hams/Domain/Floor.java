package com.example.hams.Domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Floor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String floorName;


    @OneToMany(
            fetch = FetchType.EAGER,
            mappedBy = "floor",
            cascade = CascadeType.ALL
    )
    private Set<Student> floorMates;

    @OneToMany(
            fetch = FetchType.EAGER,
            mappedBy = "floor",
            cascade = CascadeType.ALL
    )
    private Set<Room> floorRooms;
}
