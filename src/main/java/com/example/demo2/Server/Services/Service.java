package com.example.demo2.Server.Services;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class Service {
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


}
