package com.example.demo2.Server.FacadeObjects;

import com.example.demo2.Server.Business.BusinessObjects.Article;
import com.example.demo2.Server.Business.BusinessObjects.Comment;
import com.example.demo2.Server.Business.BusinessObjects.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FacadeUser extends Response{
    private String name;
    private String password;
    private List<String> articles;
    private List<Integer> comments;

    public FacadeUser(){}

    public FacadeUser(User user) {
        this.name = user.getName();
        this.password = user.getPassword();
        //initialize articles
        Map<String, Article> businessArticles = user.getArticles();
        this.articles = new ArrayList<>(businessArticles.keySet());

        //initialize comments
        Map<Integer, Comment> businessComments = user.getComments();
        this.comments = new ArrayList<>(businessComments.keySet());
    }

    public FacadeUser(String message) {
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

    public List<Integer> getComments() {
        return comments;
    }

    public void setComments(List<Integer> comments) {
        this.comments = comments;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
