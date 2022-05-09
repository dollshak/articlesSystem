package com.example.demo2.Server.Business.BusinessObjects;

import com.example.demo2.Server.SystemException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String name;
    private String password;
    private List<String> articleNames;
    private Map<String, Comment> comments;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
        this.articleNames= new ArrayList<>();
        comments = new HashMap<>();
    }

    public boolean hasArticleWithName(String title) {
        return articleNames.contains(title);
    }

    public Article CreateArticle(String title, String body) throws SystemException {
        if (hasArticleWithName(title))
            throw new SystemException("you already have an article with that name");
        Article newArticle = new Article(title, body, this.name);
        articleNames.add(title);
        return newArticle;
    }

    public Comment CreateComment(Article article, String title, String comment) throws SystemException {
        return article.createComment(title, comment, this.name);
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public List<String> getArticles() {
        return articleNames;
    }

    public Map<String, Comment> getComments() {
        return comments;
    }
}
