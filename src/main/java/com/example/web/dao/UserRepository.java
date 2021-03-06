package com.example.web.dao;

import com.example.web.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>
{
    public User getUserByUsername(String var);
}
