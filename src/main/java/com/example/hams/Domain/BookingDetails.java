package com.example.hams.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BookingDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String floor;

    private String room;

    private Student student;

    public BookingDetails() {
    }

    public BookingDetails(String floor, String room, Student student) {
        this.floor = floor;
        this.room = room;
        this.student = student;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "BookingDetails{" +
                "id=" + id +
                ", floor='" + floor + '\'' +
                ", room='" + room + '\'' +
                ", student=" + student +
                '}';
    }
}
