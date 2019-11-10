package com.example.hams.Domain;

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

    @ManyToOne
    private Student student;

    public Complaint() {
    }

    public Complaint(String message, String email, Student student) {
        this.message = message;
        this.email = email;
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

    @Override
    public String toString() {
        return "Complaint{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", email='" + email + '\'' +
                ", student=" + student +
                '}';
    }
}
