package com.example.hams.Repository;


import com.example.hams.Domain.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplaintRepository extends JpaRepository<Complaint, Long> {

}
