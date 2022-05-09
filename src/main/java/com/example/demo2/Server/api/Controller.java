package com.example.demo2.Server.api;

import com.example.demo2.Server.RequestObjects.RequestArticle;
import com.example.demo2.Server.RequestObjects.RequestComment;
import com.example.demo2.Server.RequestObjects.RequestLogin;
import com.example.demo2.Server.RequestObjects.RequestUser;
import com.example.demo2.Server.ResponseObjects.ResponseComment;
import com.example.demo2.Server.ResponseObjects.ResponseUser;
import com.example.demo2.Server.Services.ArticleService;
import com.example.demo2.Server.Services.CommentService;
import com.example.demo2.Server.Services.UserService;
import com.example.demo2.Server.ResponseObjects.ResponseArticle;
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
    public Controller(ArticleService articleService,
                      UserService userService,
                      CommentService commentService) {
        this.userService = userService;
        this.articleService = articleService;
        this.commentService = commentService;
    }


    @PostMapping("/createUser")
    @Override
    public void createUser(@RequestBody String userObject) {
        RequestUser requestUser = new RequestUser().deserialize(userObject);
        userService.createUser(requestUser);
    }

    @PostMapping("/createArticle")
    @Override
    public void createArticle(@RequestBody String articleObject) {
        RequestArticle requestArticle = new RequestArticle().deserialize(articleObject);
        articleService.createArticle(requestArticle);
    }
    @PostMapping("/createComment")
    @Override
    public void createComment(@RequestBody String commentObject) {
        RequestComment requestComment = new RequestComment().deserialize(commentObject);
        commentService.createComment(requestComment);
    }

    @GetMapping("/getUser")
    @Override
    public ResponseUser getUser(String userName) {
        return userService.getUser(userName);
    }

    @GetMapping("getArticle")
    @Override
    public ResponseArticle getArticle(@RequestBody String articleName) {
        return articleService.getArticle(articleName);
    }

    @GetMapping("getComment")
    @Override
    public ResponseComment getComment(@RequestBody String commentObject) {
        RequestComment requestComment = new RequestComment().deserialize(commentObject);
        return commentService.getComment(requestComment);
    }

    @PostMapping("/login")
    public ResponseUser login(@RequestBody String userObject){
        RequestLogin requestLogin = new RequestLogin().deserialize(userObject);
        return userService.login(requestLogin);
    }

    @PostMapping("/logout")
    public void logout(@RequestBody String userName){
        userService.logout(userName);
    }
}
