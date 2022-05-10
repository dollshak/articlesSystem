package com.example.demo2.Server.Services;

import com.example.demo2.Server.Business.BusinessObjects.Article;
import com.example.demo2.Server.Business.Controllers.ArticleController;
import com.example.demo2.Server.FacadeObjects.FacadeArticle;
import org.springframework.stereotype.Service;
import com.example.demo2.Server.RequestObjects.*;

@Service
public class ArticleService {
    private ArticleController articleController;

    public ArticleService() {
        this.articleController = ArticleController.getInstance();
    }

    public FacadeArticle createArticle(RequestArticle articleToCreate){
        FacadeArticle toReturn;
        try{
            Article article = articleController.createArticle(articleToCreate.getTitle(),
                    articleToCreate.getBody(), articleToCreate.getWriterName());
            toReturn = new FacadeArticle(article);
        }catch (Exception e){
            toReturn = new FacadeArticle(e.getMessage());
        }
        return toReturn;
    }

    public FacadeArticle getArticle(String articleName){
        FacadeArticle toReturn;
        try{
            Article article = articleController.getArticle(articleName);
            toReturn = new FacadeArticle(article);
        }catch (Exception e){
            toReturn = new FacadeArticle(e.getMessage());
        }
        return toReturn;
    }
}
