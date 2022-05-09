package com.example.demo2.Server.api;

import com.example.demo2.Server.ResponseObjects.ResponseArticle;
import com.example.demo2.Server.ResponseObjects.ResponseComment;
import com.example.demo2.Server.ResponseObjects.ResponseUser;

public interface Iapi {
    //create
    void createUser(String userObject);
    void createArticle(String articleObject);
    void createComment(String commentObject);

    //get
    ResponseUser getUser(String userName);
    ResponseArticle getArticle(String articleName);
    ResponseComment getComment(String commentObject);


}
