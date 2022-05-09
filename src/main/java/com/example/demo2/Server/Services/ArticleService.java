package com.example.demo2.Server.Services;

import com.example.demo2.Server.Business.BusinessObjects.Article;
import com.example.demo2.Server.Business.Controllers.ArticleController;
import com.example.demo2.Server.ResponseObjects.ResponseArticle;
import org.springframework.stereotype.Service;
import com.example.demo2.Server.RequestObjects.*;

@Service
public class ArticleService {
    private ArticleController articleController;

    public ArticleService() {
        this.articleController = ArticleController.getInstance();
    }

    public ResponseArticle createArticle(RequestArticle articleToCreate){
        ResponseArticle toReturn;
        try{
            Article article = articleController.createArticle(articleToCreate.getTitle(),
                    articleToCreate.getBody(), articleToCreate.getWriterName());
            toReturn = new ResponseArticle(article);
        }catch (Exception e){
            toReturn = new ResponseArticle(e.getMessage());
        }
        return toReturn;
    }

    public ResponseArticle getArticle(String articleName){
        ResponseArticle toReturn;
        try{
            Article article = articleController.getArticle(articleName);
            toReturn = new ResponseArticle(article);
        }catch (Exception e){
            toReturn = new ResponseArticle(e.getMessage());
        }
        return toReturn;
    }
}
