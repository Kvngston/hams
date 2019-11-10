package com.tk.adminserver.Domain;

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

    public Floor() {
    }

    public Floor(String floorName, Set<Student> floorMates, Set<Room> floorRooms) {
        this.floorName = floorName;
        this.floorMates = floorMates;
        this.floorRooms = floorRooms;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFloorName() {
        return floorName;
    }

    public void setFloorName(String floorName) {
        this.floorName = floorName;
    }

    public Set<Student> getFloorMates() {
        return floorMates;
    }

    public void setFloorMates(Set<Student> floorMates) {
        this.floorMates = floorMates;
    }

    public Set<Room> getFloorRooms() {
        return floorRooms;
    }

    public void setFloorRooms(Set<Room> floorRooms) {
        this.floorRooms = floorRooms;
    }

    @Override
    public String toString() {
        return "Floor{" +
                "id=" + id +
                ", floorName='" + floorName + '\'' +
                '}';
    }
}
