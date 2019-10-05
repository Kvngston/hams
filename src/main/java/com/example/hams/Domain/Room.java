package com.example.hams.Domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Room implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(
            fetch = FetchType.EAGER,
            mappedBy = "room",
            cascade = CascadeType.ALL
    )
    private Set<Student> roommates;

    @ManyToOne
    @JoinColumn(name = "floor_id")
    private Floor floor;

    public Room() {
    }

    public Room(String name, Set<Student> roommates, Floor floor) {
        this.name = name;
        this.roommates = roommates;
        this.floor = floor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Student> getRoommates() {
        return roommates;
    }

    public void setRoommates(Set<Student> roommates) {
        this.roommates = roommates;
    }

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }
}
