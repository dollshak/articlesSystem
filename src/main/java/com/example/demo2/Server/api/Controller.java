package com.example.demo2.Server.api;

import com.example.demo2.Server.Services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;

@RequestMapping(value = "/rest")
@RestController
public class Controller{
    private final Service service;
    protected MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    @Autowired
    public Controller(Service service){
        this.service = service;
    }


//    @Autowired
//    public Controller(ArticleService articleService,
//                      UserService userService,
//                      CommentService commentService) {
//        this.userService = userService;
//        this.articleService = articleService;
//        this.commentService = commentService;
//    }

//    @PostMapping("/createUser")
//    @Override
//    public void createUser(@RequestBody String userObject) {
//        System.out.println("hello");
//        RequestUser requestUser = new RequestUser().deserialize(userObject);
//        userService.createUser(requestUser);
//    }

//    @Override
//    public String createUser() {
//        return null;
//    }
//
//    @PostMapping("/createArticle")
//    @Override
//    public void createArticle(@RequestBody String articleObject) {
//        RequestArticle requestArticle = new RequestArticle().deserialize(articleObject);
//        articleService.createArticle(requestArticle);
//    }
//    @PostMapping("/createComment")
//    @Override
//    public void createComment(@RequestBody String commentObject) {
//        RequestComment requestComment = new RequestComment().deserialize(commentObject);
//        commentService.createComment(requestComment);
//    }
//
//    @GetMapping("/getNewUser")
//    public ResponseUser getUser1(@RequestParam(value = "name") String userName , @RequestParam(value = "id") int id) {
//        System.out.println(userName+ " ");
//        return userService.getUser(userName);
//    }
//    @GetMapping("/getUser")
//    @Override
//    public ResponseUser getUser(@PathVariable String userName) {
//        return userService.getUser(userName);
//    }
//
//    @GetMapping("getArticle")
//    @Override
//    public ResponseArticle getArticle(@RequestBody String articleName) {
//        return articleService.getArticle(articleName);
//    }
//
//    @GetMapping("getComment")
//    @Override
//    public ResponseComment getComment(@RequestBody String commentObject) {
//        RequestComment requestComment = new RequestComment().deserialize(commentObject);
//        return commentService.getComment(requestComment);
//    }
//
//    @PostMapping("/login")
//    public ResponseUser login(@RequestBody String userObject){
//        RequestLogin requestLogin = new RequestLogin().deserialize(userObject);
//        return userService.login(requestLogin);
//    }
//
//    @PostMapping("/logout")
//    public void logout(@RequestBody String userName){
//        userService.logout(userName);
//    }
}
