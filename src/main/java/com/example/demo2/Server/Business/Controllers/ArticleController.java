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


    public static ArticleController getInstance() {
        if (instance == null)
            instance = new ArticleController();
        return instance;
    }

    private ArticleController(){
        articles = new HashMap<>();
        userController = UserController.getInstance();
    }

    public Article createArticle(String title, String body, String writerName) throws SystemException {
        User user = userController.getUser(writerName);
        Article article = user.CreateArticle(title, body);
        articles.put(article.getTitle() , article);
        return article;
    }



    public Article getArticle(String name) throws SystemException {
        if (!articles.containsKey(name))
            throw new SystemException("no such article");
        return articles.get(name);
    }


}
