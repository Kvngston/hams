package com.tk.adminserver.Domain;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    @Email
    private String email;

    @Column(nullable = false)
    private int attendedTo;

    @ManyToOne
    private Student student;

    public Complaint() {
    }

    public Complaint(String message, @Email String email, int completed, Student student) {
        this.message = message;
        this.email = email;
        this.attendedTo = completed;
        this.student = student;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAttendedTo() {
        return attendedTo;
    }

    public void setAttendedTo(int attendedTo) {
        this.attendedTo = attendedTo;
    }

    @Override
    public String toString() {
        return "Complaint{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", email='" + email + '\'' +
                ", completed=" + attendedTo +
                ", student=" + student +
                '}';
    }
}
