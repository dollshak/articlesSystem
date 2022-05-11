package com.example.demo2.Server.Business.Controllers;

import com.example.demo2.Server.Business.BusinessObjects.Article;
import com.example.demo2.Server.Business.BusinessObjects.User;
import com.example.demo2.Server.Data.Article.ArticleRepository;
import com.example.demo2.Server.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ArticleController {
    private Map<String, Article> articles;

    @Autowired
    private ArticleRepository articleRepository;


    private ArticleController(){
        articles = new HashMap<>();
    }

    public Article createArticle(Article article) throws SystemException {
        articles.put(article.getTitle() , article);
        return article;
    }

    public Article getArticle(String name) throws SystemException {
        if (!articles.containsKey(name))
            throw new SystemException("no such article");
        return articles.get(name);
    }
}
