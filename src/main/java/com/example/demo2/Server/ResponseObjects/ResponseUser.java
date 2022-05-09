package com.example.demo2.Server.ResponseObjects;

import com.example.demo2.Server.Business.BusinessObjects.Article;
import com.example.demo2.Server.Business.BusinessObjects.Comment;
import com.example.demo2.Server.Business.BusinessObjects.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResponseUser extends Response{
    private String name;
    private List<String> articles;
    private Map<String, ResponseComment> comments;

    public ResponseUser(){}

    public ResponseUser(User user) {
        this.name = user.getName();
        //initialize articles
        this.articles = new ArrayList<>();
        List<String> businessArticles = user.getArticles();
        for (String articleName : businessArticles)
            this.articles.add(articleName);

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

    public List<String> getArticles() {
        return articles;
    }

    public void setArticles(List<String> articles) {
        this.articles = articles;
    }

    public Map<String, ResponseComment> getComments() {
        return comments;
    }

    public void setComments(Map<String, ResponseComment> comments) {
        this.comments = comments;
    }

}
