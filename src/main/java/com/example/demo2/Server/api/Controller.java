package com.example.demo2.Server.api;

import com.example.demo2.Server.Business.BusinessObjects.Article;
import com.example.demo2.Server.Business.BusinessObjects.Comment;
import com.example.demo2.Server.Business.BusinessObjects.User;
import com.example.demo2.Server.FacadeObjects.FacadeArticle;
import com.example.demo2.Server.FacadeObjects.FacadeComment;
import com.example.demo2.Server.FacadeObjects.FacadeUser;
import com.example.demo2.Server.Services.ArticleService;
import com.example.demo2.Server.Services.CommentService;
import com.example.demo2.Server.Services.UserService;
import org.atmosphere.config.service.Get;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;

@RequestMapping(value = "/rest")
@RestController
public class Controller implements Iapi{
    private final UserService userService;
    private final ArticleService articleService;
    private final CommentService commentService;
    protected MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    @Autowired
    public Controller(UserService userService, ArticleService articleService,
                      CommentService commentService){
        this.userService = userService;
        this.articleService = articleService;
        this.commentService = commentService;
    }

    @PostMapping(value = "/user")
    @Override
    public FacadeUser createUser(@RequestBody FacadeUser userToCreate) {
        FacadeUser toReturn;
        try {
            User user = userService.createUser(userToCreate);
            toReturn = new FacadeUser(user);
        }catch (Exception e){
            toReturn = new FacadeUser(e.getMessage());
        }
        return toReturn;
    }

    @PostMapping(value = "/article")
    @Override
    public FacadeArticle createArticle(@RequestBody FacadeArticle articleToCreate) {
        FacadeArticle toReturn;
        try{
            Article article = userService.createArticle(articleToCreate);
            articleService.createArticle(article);
            toReturn = new FacadeArticle(article);
        }catch (Exception e){
            toReturn = new FacadeArticle(e.getMessage());
        }
        return toReturn;
    }

    @PostMapping(value = "/comment")
    @Override
    public FacadeComment createComment(@RequestBody FacadeComment commentToCreate) {
        FacadeComment toReturn;
        try{
            Article articleToCommentOn = articleService.getArticle(commentToCreate.getArticle());
            Comment comment = userService.createComment(commentToCreate, articleToCommentOn);
            commentService.createComment(comment);
            toReturn = new FacadeComment(comment);
        }catch (Exception e){
            toReturn = new FacadeComment(e.getMessage());
        }
        return toReturn;
    }

    @GetMapping(value = "/user")
    @Override
    public FacadeUser getUser(@RequestParam(value = "name") String userName) {
        FacadeUser toReturn;
        try {
            User user = userService.getUser(userName);
            toReturn = new FacadeUser(user);
        }catch (Exception e){
            toReturn = new FacadeUser(e.getMessage());
        }
        return toReturn;
    }

    @GetMapping(value = "/article")
    @Override
    public FacadeArticle getArticle(@RequestParam(value = "articleName")String articleName) {
        FacadeArticle toReturn;
        try{
            Article article = articleService.getArticle(articleName);
            toReturn = new FacadeArticle(article);
        }catch (Exception e){
            toReturn = new FacadeArticle(e.getMessage());
        }
        return toReturn;
    }

    @GetMapping(value = "/comment")
    @Override
    public FacadeComment getComment(@RequestParam(value = "commentId")int commentId) {
        FacadeComment toReturn;
        try{
            Comment comment = commentService.getComment(commentId);
            toReturn = new FacadeComment(comment);
        }catch (Exception e){
            toReturn = new FacadeComment(e.getMessage());
        }
        return toReturn;
    }
}
