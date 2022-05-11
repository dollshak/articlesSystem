package com.example.demo2.Server.Services;

import com.example.demo2.Server.Business.BusinessObjects.Article;
import com.example.demo2.Server.Business.Controllers.ArticleController;
import com.example.demo2.Server.FacadeObjects.FacadeArticle;
import com.example.demo2.Server.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {
    @Autowired
    private ArticleController articleController;

    public ArticleService() {
    }

    public Article createArticle(Article articleToCreate) throws SystemException {
        return articleController.createArticle(articleToCreate);
    }

    public Article getArticle(String articleName) throws SystemException {
        return articleController.getArticle(articleName);
    }

}
