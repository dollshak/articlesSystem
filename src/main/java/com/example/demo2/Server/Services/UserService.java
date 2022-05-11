package com.example.demo2.Server.Services;

import com.example.demo2.Server.Business.BusinessObjects.Article;
import com.example.demo2.Server.Business.BusinessObjects.Comment;
import com.example.demo2.Server.Business.BusinessObjects.User;
import com.example.demo2.Server.Business.Controllers.ArticleController;
import com.example.demo2.Server.Business.Controllers.UserController;
import com.example.demo2.Server.FacadeObjects.FacadeArticle;
import com.example.demo2.Server.FacadeObjects.FacadeComment;
import com.example.demo2.Server.FacadeObjects.FacadeUser;
import com.example.demo2.Server.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserController userController;

    public UserService() {
    }

    public User createUser(FacadeUser userToCreate) throws SystemException {
        return userController.createUser(userToCreate.getName(), userToCreate.getPassword());
    }

    public User getUser(String userName) throws SystemException {
        return userController.getUser(userName);
    }

    public Article createArticle(FacadeArticle articleToCreate) throws SystemException {
        return userController.createArticle(articleToCreate.getTitle(), articleToCreate.getBody(),
                articleToCreate.getWriterName());
    }

    public Comment createComment(FacadeComment commentToCreate, Article article) throws SystemException {
        return userController.createComment(article,
                commentToCreate.getTitle(),
                commentToCreate.getCommentBody(),
                commentToCreate.getWriter());
    }
}
