package com.example.demo2.Server.Business.Controllers;

import com.example.demo2.Server.Business.BusinessObjects.Comment;
import com.example.demo2.Server.SystemException;

import java.util.Map;

public class CommentController {
    private Map<Integer, Comment> commentsById;

    public CommentController() {
    }

    public Comment getComment(int commentId) throws SystemException {
        if (!commentsById.containsKey(commentId))
            throw new SystemException("no such comment");
        return commentsById.get(commentId);
    }

}
