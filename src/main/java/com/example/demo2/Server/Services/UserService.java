package com.example.demo2.Server.Services;

import com.example.demo2.Server.Business.BusinessObjects.User;
import com.example.demo2.Server.Business.Controllers.ArticleController;
import com.example.demo2.Server.RequestObjects.RequsetUser;
import com.example.demo2.Server.ResponseObjects.ResponseUser;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private ArticleController articleController;

    public UserService() {
        articleController = ArticleController.getInstance();
    }

    public ResponseUser createUser(RequsetUser userToCreate) {
        ResponseUser toReturn;
        try {
            User user = articleController.createUser(userToCreate.getName(),
                    userToCreate.getPassword(),
                    userToCreate.getValidatePassword());
            toReturn = new ResponseUser(user);
        }catch (Exception e){
            toReturn = new ResponseUser(e.getMessage());
        }
        return toReturn;
    }

    public ResponseUser getUser(String userName){
        ResponseUser toReturn;
        try {
            User user = articleController.getUser(userName);
            toReturn = new ResponseUser(user);
        }catch (Exception e){
            toReturn = new ResponseUser(e.getMessage());
        }
        return toReturn;
    }
}
