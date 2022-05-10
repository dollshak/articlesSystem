package com.example.demo2.Server.Business.Controllers;

import com.example.demo2.Server.Business.BusinessObjects.Article;
import com.example.demo2.Server.Business.BusinessObjects.Comment;
import com.example.demo2.Server.Business.BusinessObjects.User;
import com.example.demo2.Server.SystemException;

import java.util.HashMap;
import java.util.Map;

public class ArticleController {
    private Map<String, Article> articles;
    private UserController userController;
    private static ArticleController instance;

    public synchronized static ArticleController getInstance() {
        if (instance == null)
            instance = new ArticleController();
        return instance;
    }

    private ArticleController(){
        articles = new HashMap<>();
        userController = UserController.getInstance();
    }

    //create methods
    public User createUser(String name, String password, String validatePassword) throws SystemException {
        return userController.createUser(name, password, validatePassword);
    }

    public Article createArticle(String title, String body, String writer) throws SystemException {
        User user = userController.getLoggedInUser(writer);
        Article article = user.CreateArticle(title, body);
        articles.put(article.getTitle() , article);
        return article;
    }

    public Comment createComment(String title, String comment, String articleName, String commenter) throws SystemException {
        User user = userController.getLoggedInUser(commenter);
        if (!articles.containsKey(articleName))
            throw new SystemException("no such article");
        Article articleToCommentOn = articles.get(articleName);
        return user.CreateComment(articleToCommentOn, title, comment);
    }

    //get memthods
    public User getUser(String name) throws SystemException {
        return userController.getUser(name);
    }

    public Article getArticle(String name) throws SystemException {
        if (!articles.containsKey(name))
            throw new SystemException("no such article");
        return articles.get(name);
    }

    public Comment getComment(String articleName, String commentTitle) throws SystemException {
        if (!articles.containsKey(articleName))
            throw new SystemException("no such article");
        Article article = articles.get(articleName);
        return article.getComment(commentTitle);
    }

    public User login(String name, String password) throws SystemException {
        return userController.login(name, password);
    }

    public void logout(String userName) throws SystemException {
        userController.logout(userName);
    }
}
