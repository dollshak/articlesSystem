package com.example.demo2.Server.api;

import com.example.demo2.Server.ResponseObjects.ResponseArticle;
import com.example.demo2.Server.ResponseObjects.ResponseComment;
import com.example.demo2.Server.ResponseObjects.ResponseUser;

public interface Iapi {
    //create
    ResponseUser createUser(String userObject);
    ResponseArticle createArticle(String articleObject);
    ResponseComment createComment(String commentObject);

    //get
    ResponseUser getUser(String userName);
    ResponseArticle getArticle(String articleName);
    ResponseComment getComment(String commentObject);


}
