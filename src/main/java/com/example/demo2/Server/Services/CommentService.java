package com.example.demo2.Server.Services;

import com.example.demo2.Server.Business.BusinessObjects.Comment;
import com.example.demo2.Server.Business.Controllers.ArticleController;
import com.example.demo2.Server.Business.Controllers.CommentController;
import com.example.demo2.Server.FacadeObjects.FacadeComment;
import org.springframework.stereotype.Service;
import com.example.demo2.Server.RequestObjects.*;

@Service
public class CommentService {
    private CommentController commentController;

    public CommentService() {
        this.commentController = CommentController.getInstance();
    }

//    public int createComment(RequestComment commentToCreate){
//        FacadeComment toReturn;
//        try{
//            Comment comment = articleController.createComment(commentToCreate.getTitle(),
//                    commentToCreate.getCommentBody(),
//                    commentToCreate.getArticleName(),
//                    commentToCreate.getWriter());
//            toReturn = new FacadeComment(comment);
//        }catch (Exception e){
//            toReturn = new FacadeComment(e.getMessage());
//        }
//        return toReturn;
//    }
//
//    public FacadeComment getComment(RequestComment commentToReturn){
//        FacadeComment toReturn;
//        try{
//            Comment comment = articleController.getComment(commentToReturn.getArticleName(),
//                    commentToReturn.getTitle());
//            toReturn = new FacadeComment(comment);
//        }catch (Exception e){
//            toReturn = new FacadeComment(e.getMessage());
//        }
//        return toReturn;
//    }

}
