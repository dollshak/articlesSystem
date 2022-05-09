package com.example.demo2.Server.Services;

import com.example.demo2.Server.Business.BusinessObjects.Article;
import com.example.demo2.Server.Business.BusinessObjects.Comment;
import com.example.demo2.Server.Business.Controllers.ArticleController;
import com.example.demo2.Server.ResponseObjects.ResponseArticle;
import com.example.demo2.Server.ResponseObjects.ResponseComment;
import org.springframework.stereotype.Service;
import com.example.demo2.Server.RequestObjects.*;

@Service
public class CommentService {
    private ArticleController articleController;

    public CommentService() {
        this.articleController = ArticleController.getInstance();
    }

    public ResponseComment createComment(RequestComment commentToCreate){
        ResponseComment toReturn;
        try{
            Comment comment = articleController.createComment(commentToCreate.getTitle(),
                    commentToCreate.getCommentBody(),
                    commentToCreate.getArticleName(),
                    commentToCreate.getWriter());
            toReturn = new ResponseComment(comment);
        }catch (Exception e){
            toReturn = new ResponseComment(e.getMessage());
        }
        return toReturn;
    }

    public ResponseComment getComment(RequestComment commentToReturn){
        ResponseComment toReturn;
        try{
            Comment comment = articleController.getComment(commentToReturn.getArticleName(),
                    commentToReturn.getTitle());
            toReturn = new ResponseComment(comment);
        }catch (Exception e){
            toReturn = new ResponseComment(e.getMessage());
        }
        return toReturn;
    }



}
