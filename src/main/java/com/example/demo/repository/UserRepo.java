package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, String> {

}
