package com.example.demo2.Server.Business.Controllers;

import com.example.demo2.Server.Business.BusinessObjects.Article;
import com.example.demo2.Server.Business.BusinessObjects.Comment;
import com.example.demo2.Server.Business.BusinessObjects.User;
import com.example.demo2.Server.SystemException;

import java.util.HashMap;
import java.util.Map;

public class ArticleController {
    private Map<String, Article> articles;
    private static ArticleController instance;

    public synchronized static ArticleController getInstance() {
        if (instance == null)
            instance = new ArticleController();
        return instance;
    }

    private ArticleController(){
        articles = new HashMap<>();
    }

    public Article createArticle(String title, String body, User writer) throws SystemException {
        Article article = writer.CreateArticle(title, body);
        articles.put(article.getTitle() , article);
        return article;
    }

    public Comment createComment(String title, String comment, String articleName, User commenter) throws SystemException {
        if (!articles.containsKey(articleName))
            throw new SystemException("no such article");
        Article articleToCommentOn = articles.get(articleName);
        return commenter.CreateComment(articleToCommentOn, title, comment);
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

}
