package com.example.demo2.Server.Data.User;

import com.example.demo2.Server.Data.User.DalUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<DalUser, String> {
}
