package com.example.demo2.Server.Business.BusinessObjects;

import com.example.demo2.Server.SystemException;

import java.util.HashMap;
import java.util.Map;

public class User {
    private String name;
    private String password;
    private Map<String, Article> articles;
    private Map<String, Comment> comments;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
        articles = new HashMap<>();
        comments = new HashMap<>();
    }

    public boolean hasArticleWithName(String title) {
        return articles.containsKey(title);
    }

    public Article CreateArticle(String title, String body) throws SystemException {
        if (hasArticleWithName(title))
            throw new SystemException("you already have an article with that name");
        Article newArticle = new Article(title, body, this.name);
        articles.put(title, newArticle);
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

    public Map<String, Article> getArticles() {
        return articles;
    }

    public Map<String, Comment> getComments() {
        return comments;
    }
}
