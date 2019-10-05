package com.tk.adminserver.Repository;

import com.tk.adminserver.Domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findByRegNo(String regNo);
}
