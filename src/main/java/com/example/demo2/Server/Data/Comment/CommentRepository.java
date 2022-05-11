package com.example.demo2.Server.Data.Comment;

import com.example.demo2.Server.Data.User.DalUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<DalComment, Integer> {
}
