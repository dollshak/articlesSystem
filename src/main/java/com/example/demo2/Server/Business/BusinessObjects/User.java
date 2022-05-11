package com.example.demo2.Server.Business.BusinessObjects;

import com.example.demo2.Server.Data.User.DalUser;
import com.example.demo2.Server.SystemException;

import java.util.HashMap;
import java.util.Map;

public class User {
    private final String name; //unique
    private String password;
    private Map<String, Article> articleNames;
    private Map<String, Comment> comments;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
        this.articleNames= new HashMap<>();
        comments = new HashMap<>();
    }

    public boolean hasArticleWithName(String title) {
        return articleNames.containsKey(title);
    }

    public Article CreateArticle(String title, String body) throws SystemException {
        if (hasArticleWithName(title))
            throw new SystemException("you already have an article with that name");
        Article newArticle = new Article(title, body, this.name);
        articleNames.put(title, newArticle);
        return newArticle;
    }

    public Comment CreateComment(Article article, String title, String comment) throws SystemException {
        Comment newComment = article.createComment(title, comment, this.name);
        this.comments.put(title, newComment);
        return newComment;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public Map<String, Article> getArticles() {
        return articleNames;
    }

    public Map<String, Comment> getComments() {
        return comments;
    }

    public DalUser toDalObject(){
        return new DalUser(name, password);
    }
}
