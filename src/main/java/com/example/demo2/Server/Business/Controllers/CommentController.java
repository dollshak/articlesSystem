package com.example.demo2.Server.Business.Controllers;
import com.example.demo2.Server.Business.BusinessObjects.Article;
import com.example.demo2.Server.Business.BusinessObjects.Comment;
import com.example.demo2.Server.Business.BusinessObjects.User;
import com.example.demo2.Server.Data.Comment.CommentRepository;
import com.example.demo2.Server.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CommentController {
    private Map<Integer, Comment> commentsById;
    @Autowired
    private CommentRepository commentRepository;

    public CommentController() {
        commentsById = new HashMap<>();
    }

    public Comment getComment(int commentId) throws SystemException {
        if (!commentsById.containsKey(commentId))
            throw new SystemException("no such comment");
        return commentsById.get(commentId);
    }

    public Comment createComment(Comment newComment) throws SystemException {
        commentRepository.save(newComment.toDalObject());
        commentsById.put(newComment.getId(), newComment);
        return newComment;
    }
}
