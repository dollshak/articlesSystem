package com.example.demo2.Server.Business.Controllers;

import com.example.demo2.Server.Business.BusinessObjects.Article;
import com.example.demo2.Server.Business.BusinessObjects.Comment;
import com.example.demo2.Server.Business.BusinessObjects.User;
import com.example.demo2.Server.Data.User.UserRepository;
import com.example.demo2.Server.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserController {
    private Map<String, User> users;
    private int nextCommentId;

    @Autowired
    private UserRepository userRepository;
    private static UserController instance;

    public static UserController getInstance() {
        if (instance == null)
            instance = new UserController();
        return instance;
    }

    private UserController(){
        users = new HashMap<>();
        nextCommentId = 1;
    }

    public User createUser(String name, String password) throws SystemException {
        if (users.containsKey(name))
            throw new SystemException("username already exists in the system, please choose another username");
        User newUser = new User(name, password);
        userRepository.save(newUser.getDalUser());
        users.put(name, newUser);
        return newUser;
    }

    public User getUser(String name) throws SystemException {
        if (!users.containsKey(name))
            throw new SystemException("no such user");
        return users.get(name);
    }

    public Article createArticle(String title, String body, String writer) throws SystemException {
        if (!users.containsKey(writer))
            throw new SystemException("no such user");
        User user = users.get(writer);
        Article newArticle = user.createArticle(title, body);
        userRepository.save(user.getDalUser());
        return newArticle;
    }

    public Comment createComment(Article article, String title, String commentBody,
                                 String writer) throws SystemException {
        if (!users.containsKey(writer))
            throw new SystemException("no such user");
        User user = users.get(writer);
        Comment newComment = user.createComment(article, title, commentBody, getNextCommentId());
        userRepository.save(user.getDalUser());
        return newComment;
    }

    private int getNextCommentId(){
        int toReturn = this.nextCommentId;
        this.nextCommentId++;
        return toReturn;
    }
}