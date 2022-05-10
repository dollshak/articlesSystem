package com.example.demo2.Server.api;

import com.example.demo2.Server.FacadeObjects.FacadeArticle;
import com.example.demo2.Server.FacadeObjects.FacadeComment;
import com.example.demo2.Server.FacadeObjects.FacadeUser;
import com.example.demo2.Server.Services.Service;
import org.atmosphere.config.service.Get;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;

@RequestMapping(value = "/rest")
@RestController
public class Controller implements Iapi{
    private final Service service;
    protected MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    @Autowired
    public Controller(Service service){
        this.service = service;
    }

    @GetMapping(value = "/user1")
    public FacadeUser createUser1(@RequestParam (value = "name") String name){
        return new FacadeUser();
    }
    @PostMapping(value = "/user")
    @Override
    public FacadeUser createUser(FacadeUser user) {
        return service.createUser(user);
    }

    @PostMapping(value = "/article")
    @Override
    public FacadeArticle createArticle(FacadeArticle article) {
        return service.createArticle(article);
    }

    @PostMapping(value = "/comment")
    @Override
    public FacadeComment createComment(FacadeComment comment) {
        return service.createComment(comment);
    }

    @GetMapping(value = "/user")
    @Override
    public FacadeUser getUser(String userName) {
        return service.getUser(userName);
    }

    @GetMapping(value = "/article")
    @Override
    public FacadeArticle getArticle(String articleName) {
        return service.getArticle(articleName);
    }

    @GetMapping(value = "/comment")
    @Override
    public FacadeComment getComment(int articleId) {
        return service.getComment(articleId);
    }
}
