package com.example.demo2.Server.Services;

import com.example.demo2.Server.Business.BusinessObjects.Article;
import com.example.demo2.Server.Business.BusinessObjects.Comment;
import com.example.demo2.Server.Business.Controllers.ArticleController;
import com.example.demo2.Server.Business.Controllers.CommentController;
import com.example.demo2.Server.FacadeObjects.FacadeComment;
import com.example.demo2.Server.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    private CommentController commentController;

    public CommentService() {
    }

    public Comment createComment(Comment comment) throws SystemException {
        return commentController.createComment(comment);
    }

    public Comment getComment(int commentId) throws SystemException {
        return commentController.getComment(commentId);
    }

}
