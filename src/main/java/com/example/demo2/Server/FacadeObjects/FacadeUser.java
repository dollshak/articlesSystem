package com.example.demo2.Server.FacadeObjects;

import com.example.demo2.Server.Business.BusinessObjects.Article;
import com.example.demo2.Server.Business.BusinessObjects.Comment;
import com.example.demo2.Server.Business.BusinessObjects.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.util.HashMap;
import java.util.Map;

public class FacadeUser extends Response{
    private String name;
    private String password;
    private Map<String, FacadeArticle> articles;
    private Map<String, FacadeComment> comments;

    public FacadeUser(){}

    public FacadeUser(User user) {
        this.name = user.getName();
        this.password = user.getPassword();
        //initialize articles
        this.articles = new HashMap<>();
        Map<String, Article> businessArticles = user.getArticles();
        for (Map.Entry<String, Article> entry : businessArticles.entrySet())
            this.articles.put(entry.getKey(), new FacadeArticle(entry.getValue()));

        //initialize comments
        this.comments = new HashMap<>();
        Map<String, Comment> businessComments = user.getComments();
        for (Map.Entry<String, Comment> entry : businessComments.entrySet()) {
            Comment comment = entry.getValue();
            FacadeComment facadeComment = new FacadeComment(comment);
            this.comments.put(entry.getKey(), new FacadeComment(entry.getValue()));
        }
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


    public Map<String, FacadeArticle> getArticles() {
        return articles;
    }

    public void setArticles(Map<String, FacadeArticle> articles) {
        this.articles = articles;
    }

    public Map<String, FacadeComment> getComments() {
        return comments;
    }

    public void setComments(Map<String, FacadeComment> comments) {
        this.comments = comments;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toJson(){
        String json = "";
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        try {
            json = ow.writeValueAsString(this);
        }catch (Exception e){}
        return json;
    }
}
