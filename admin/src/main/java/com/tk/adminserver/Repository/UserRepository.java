package com.tk.adminserver.Repository;


import com.tk.adminserver.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmail(String email);
    User findByUserName(String username);
}
