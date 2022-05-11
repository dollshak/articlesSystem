package com.example.demo2.Server.Services;

import com.example.demo2.Server.Business.BusinessObjects.Article;
import com.example.demo2.Server.Business.BusinessObjects.Comment;
import com.example.demo2.Server.Business.Controllers.ArticleController;
import com.example.demo2.Server.Business.Controllers.CommentController;
import com.example.demo2.Server.FacadeObjects.FacadeComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    private CommentController commentController;

    public CommentService() {
    }

    public FacadeComment createComment(FacadeComment commentToCreate, Article article){
        FacadeComment toReturn;
        try{
            Comment comment = commentController.createComment(commentToCreate.getTitle(),
                    commentToCreate.getCommentBody(),
                    commentToCreate.getArticle(),
                    commentToCreate.getWriter(),
                    article);
            toReturn = new FacadeComment(comment);
        }catch (Exception e){
            toReturn = new FacadeComment(e.getMessage());
        }
        return toReturn;
    }

    public FacadeComment getComment(int commentId){
        FacadeComment toReturn;
        try{
            Comment comment = commentController.getComment(commentId);
            toReturn = new FacadeComment(comment);
        }catch (Exception e){
            toReturn = new FacadeComment(e.getMessage());
        }
        return toReturn;
    }

}
