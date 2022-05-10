package com.example.demo2.Server.Business.Controllers;
import com.example.demo2.Server.Business.BusinessObjects.Article;
import com.example.demo2.Server.Business.BusinessObjects.Comment;
import com.example.demo2.Server.Business.BusinessObjects.User;
import com.example.demo2.Server.SystemException;

import java.util.HashMap;
import java.util.Map;

public class CommentController {
    private Map<Integer, Comment> commentsById;
    private UserController userController;
    private static CommentController instance;

    public static CommentController getInstance() {
        if (instance == null)
            instance = new CommentController();
        return instance;
    }

    public CommentController() {
        commentsById = new HashMap<>();
        userController = UserController.getInstance();
    }

    public Comment getComment(int commentId) throws SystemException {
        if (!commentsById.containsKey(commentId))
            throw new SystemException("no such comment");
        return commentsById.get(commentId);
    }

    public Comment createComment(String title, String comment, String articleName, String commenterName,
                                 Article article) throws SystemException {
        User user = userController.getUser(commenterName);
        Comment newComment = user.CreateComment(article, title, comment);
        commentsById.put(newComment.getId(), newComment);
        return newComment;
    }
}
