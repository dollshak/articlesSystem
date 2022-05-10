package com.example.demo2.Server.Services;

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
        return null;
    }

    public FacadeUser createUser1(FacadeUser user) {
        return userService.createUser(user);
    }


    @Override
    public FacadeArticle createArticle(FacadeArticle article) {
        return null;
    }

    @Override
    public FacadeComment createComment(FacadeComment comment) {
        return null;
    }

    @Override
    public FacadeUser getUser(String userName) {
        return null;
    }

    @Override
    public FacadeArticle getArticle(String articleName) {
        return null;
    }

    @Override
    public FacadeComment getComment(int articleId) {
        return null;
    }
}
