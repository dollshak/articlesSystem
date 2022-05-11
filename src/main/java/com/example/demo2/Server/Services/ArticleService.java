package com.example.demo2.Server.Services;

import com.example.demo2.Server.Business.BusinessObjects.Article;
import com.example.demo2.Server.Business.Controllers.ArticleController;
import com.example.demo2.Server.FacadeObjects.FacadeArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {
    @Autowired
    private ArticleController articleController;

    public ArticleService() {
    }

    public FacadeArticle createArticle(FacadeArticle articleToCreate){
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

    public Article getBusinessArticle(String articleName){
        Article toReturn = null;
        try{
            toReturn = articleController.getArticle(articleName);
        }catch (Exception e){}
        return toReturn;
    }
}
