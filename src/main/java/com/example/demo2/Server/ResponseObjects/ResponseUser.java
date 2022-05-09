package com.example.demo2.Server.ResponseObjects;

import com.example.demo2.Server.Business.BusinessObjects.Article;
import com.example.demo2.Server.Business.BusinessObjects.Comment;
import com.example.demo2.Server.Business.BusinessObjects.User;

import java.util.HashMap;
import java.util.Map;

public class ResponseUser extends Response{
    private String name;
    private String password;
    private Map<String, ResponseArticle> articles;
    private Map<String, ResponseComment> comments;

    public ResponseUser(){}

    public ResponseUser(User user) {
        this.name = user.getName();
        this.password = user.getPassword();
        //initialize articles
        this.articles = new HashMap<>();
        Map<String, Article> businessArticles = user.getArticles();
        for (Map.Entry<String, Article> entry : businessArticles.entrySet())
            this.articles.put(entry.getKey(), new ResponseArticle(entry.getValue()));

        //initialize comments
        this.comments = new HashMap<>();
        Map<String, Comment> businessComments = user.getComments();
        for (Map.Entry<String, Comment> entry : businessComments.entrySet())
            this.comments.put(entry.getKey(), new ResponseComment(entry.getValue()));
    }

    public ResponseUser(String message) {
        super(message);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Map<String, ResponseArticle> getArticles() {
        return articles;
    }

    public void setArticles(Map<String, ResponseArticle> articles) {
        this.articles = articles;
    }

    public Map<String, ResponseComment> getComments() {
        return comments;
    }

    public void setComments(Map<String, ResponseComment> comments) {
        this.comments = comments;
    }
}
