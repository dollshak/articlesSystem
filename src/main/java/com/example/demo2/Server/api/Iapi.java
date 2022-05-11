package com.example.demo2.Server.api;

import com.example.demo2.Server.FacadeObjects.FacadeArticle;
import com.example.demo2.Server.FacadeObjects.FacadeComment;
import com.example.demo2.Server.FacadeObjects.FacadeFindString;
import com.example.demo2.Server.FacadeObjects.FacadeUser;

import java.util.List;

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
     * @return new article
     */
    FacadeArticle createArticle(FacadeArticle article);

    /**
     *
     * @param comment
     * @return new comment
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

    /**
     *
     * @param str - string to find in articles
     * @return articles and offests in articles of str
     */
    List<FacadeFindString> findString(String str);

}
