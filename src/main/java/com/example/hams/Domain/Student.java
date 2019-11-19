package com.example.hams.Domain;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Student implements Serializable  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstName;

    private String middleName;

    private String lastName;

    private int age;

    private String gender;

    @Size(max = 10)
    private String regNo;

    private String department;

    private String faculty;

    private String roomNumber;

    private String password;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(name = "student_role",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Role role;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "floor_id")
    private Floor floor;

    @OneToMany
    private Set<Complaint> studentComplaints;

    public Student() {
    }

    public Student(String firstName, String middleName, String lastName, int age, String gender, @Size(max = 10) String regNo, String department, String faculty, String roomNumber, String password, Role role, Room room, Floor floor, Set<Complaint> studentComplaints) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.regNo = regNo;
        this.department = department;
        this.faculty = faculty;
        this.roomNumber = roomNumber;
        this.password = password;
        this.role = role;
        this.room = room;
        this.floor = floor;
        this.studentComplaints = studentComplaints;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Set<Complaint> getStudentComplaints() {
        return studentComplaints;
    }

    public void setStudentComplaints(Set<Complaint> studentComplaints) {
        this.studentComplaints = studentComplaints;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", regNo='" + regNo + '\'' +
                ", department='" + department + '\'' +
                ", Faculty='" + faculty + '\'' +
                ", roomNumber='" + roomNumber + '\'' +
                '}';
    }
}
