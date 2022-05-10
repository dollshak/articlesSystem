package com.example.demo2.Server.api;

import com.example.demo2.Server.FacadeObjects.FacadeArticle;
import com.example.demo2.Server.FacadeObjects.FacadeComment;
import com.example.demo2.Server.FacadeObjects.FacadeUser;

public interface Iapi {

    /**
     *
     * @param user
     * @return
     */
    FacadeUser createUser(FacadeUser user);

    /**
     *
     * @param article
     * @return new article's name
     */
    FacadeArticle createArticle(FacadeArticle article);

    /**
     *
     * @param comment
     * @return new comment's id
     */
    FacadeComment createComment(FacadeComment comment);

    /**
     *
     * @param userName
     * @return user
     */
    FacadeUser getUser(String userName);

    /**
     *
     * @param articleName
     * @return article
     */
    FacadeArticle getArticle(String articleName);

    /**
     *
     * @param articleId
     * @return comment
     */
    FacadeComment getComment(int articleId);

}
