package com.example.demo2.Server.Services;

import com.example.demo2.Server.Business.BusinessObjects.Article;
import com.example.demo2.Server.Business.BusinessObjects.User;
import com.example.demo2.Server.FacadeObjects.FacadeArticle;
import com.example.demo2.Server.FacadeObjects.FacadeComment;
import com.example.demo2.Server.FacadeObjects.FacadeUser;
import com.example.demo2.Server.api.Iapi;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class Service implements Iapi {
    private UserService userService;
    private ArticleService articleService;
    private CommentService commentService;

    @Autowired
    public Service(UserService userService, ArticleService articleService,
                   CommentService commentService){
        this.userService = userService;
        this.articleService = articleService;
        this.commentService = commentService;
    }

    @Override
    public FacadeUser createUser(FacadeUser user) {
        return userService.createUser(user);
    }

    @Override
    public FacadeArticle createArticle(FacadeArticle article) {
        return articleService.createArticle(article);
    }

    @Override
    public FacadeComment createComment(FacadeComment comment) {
        Article article = articleService.getBusinessArticle(comment.getArticle());
        return commentService.createComment(comment, article);
    }

    @Override
    public FacadeUser getUser(String userName) {
        return userService.getUser(userName);
    }

    @Override
    public FacadeArticle getArticle(String articleName) {
        return articleService.getArticle(articleName);
    }

    @Override
    public FacadeComment getComment(int commentId) {
        return commentService.getComment(commentId);
    }
}
