package com.example.demo2.Server.api;

import com.example.demo2.Server.Services.ArticleService;
import com.example.demo2.Server.Services.CommentService;
import com.example.demo2.Server.Services.UserService;
import com.example.demo2.Server.objects.user;
import com.example.demo2.Server.Services.service;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;
import java.util.Map;

@RequestMapping(value = "/rest")
@RestController
public class Controller {
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

    @PostMapping("/user")
    public String register(@RequestBody String jsonUser){
        user user = deserialize(jsonUser);
        return "registered successfully";
    }

    @GetMapping
    public user login(){
        System.out.println("hi from controller");
        user user = new user("shaked" , "sisma");
        return user;
    }

    public user getUser(@RequestBody String name){
        return new user(name, "sisma");
    }

    public user deserialize(String jsonUser){
        user toReturn = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            Map<String, Object> map = mapper.readValue(jsonUser, Map.class);
            toReturn = (user) map.get(0);
        }catch (Exception e){}
        return toReturn;
    }
}
