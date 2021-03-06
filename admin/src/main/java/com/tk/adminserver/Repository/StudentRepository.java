package com.tk.adminserver.Repository;

import com.tk.adminserver.Domain.Floor;
import com.tk.adminserver.Domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findByRegNo(String regNo);

    List<Student> findAllByFloor(Floor floor);
}
