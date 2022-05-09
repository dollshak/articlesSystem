package com.example.demo2.Server.api;

import com.example.demo2.Server.ResponseObjects.ResponseComment;
import com.example.demo2.Server.ResponseObjects.ResponseUser;
import com.example.demo2.Server.Services.ArticleService;
import com.example.demo2.Server.Services.CommentService;
import com.example.demo2.Server.Services.UserService;
import com.example.demo2.Server.ResponseObjects.ResponseArticle;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;
import java.util.Map;

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
    public ResponseUser createUser(@RequestBody String userObject) {
        return null;
    }

    @PostMapping("/createArticle")
    @Override
    public ResponseArticle createArticle(@RequestBody String articleObject) {
        return null;
    }
    @PostMapping("/createComment")
    @Override
    public ResponseComment createComment(@RequestBody String commentObject) {
        return null;
    }

    @GetMapping("/getUser")
    @Override
    public ResponseUser getUser(String userName) {
        return null;
    }

    @GetMapping("getArticle")
    @Override
    public ResponseArticle getArticle(@RequestBody String articleName) {
        return null;
    }

    @GetMapping("getComment")
    @Override
    public ResponseComment getComment(@RequestBody String commentObject) {
        return null;
    }

    @PostMapping("/login")
    public ResponseUser login(@RequestBody String userObject){
        return null;
    }

    @PostMapping("/logout")
    public ResponseUser logout(@RequestBody String userObject){
        return null;
    }

    public ResponseUser deserialize(String jsonUser){
        ResponseUser toReturn = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            Map<String, Object> map = mapper.readValue(jsonUser, Map.class);
            toReturn = (ResponseUser) map.get(0);
        }catch (Exception e){}
        return toReturn;
    }
}
