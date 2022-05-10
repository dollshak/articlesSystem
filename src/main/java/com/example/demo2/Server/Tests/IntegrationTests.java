package com.example.demo2.Server.Tests;

import com.example.demo2.Server.Business.Controllers.ArticleController;

public class IntegrationTests {
    public void test() {
        try {
            String name = "shaked";
            ArticleController ac = ArticleController.getInstance();
            ac.createUser("shaked", "1234", "1234");
            ac.login(name, "1234");
            ac.createArticle("title", "bla bla", "shaked");
            ac.createComment("title", "bla bla", "title", "shaked");
        }catch (Exception e){}
    }

}
