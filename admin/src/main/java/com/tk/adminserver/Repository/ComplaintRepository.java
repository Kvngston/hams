package com.tk.adminserver.Repository;


import com.tk.adminserver.Domain.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplaintRepository extends JpaRepository<Complaint, Long> {

}
