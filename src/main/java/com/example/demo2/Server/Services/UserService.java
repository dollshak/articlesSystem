package com.example.demo2.Server.Services;

import com.example.demo2.Server.Business.BusinessObjects.User;
import com.example.demo2.Server.Business.Controllers.ArticleController;
import com.example.demo2.Server.RequestObjects.RequestLogin;
import com.example.demo2.Server.RequestObjects.RequestUser;
import com.example.demo2.Server.ResponseObjects.ResponseUser;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private ArticleController articleController;

    public UserService() {
        articleController = ArticleController.getInstance();
    }

    public ResponseUser createUser(RequestUser userToCreate) {
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

    public ResponseUser login(RequestLogin requestUser){
        ResponseUser toReturn;
        try {
            User user = articleController.login(requestUser.getName(),
                    requestUser.getPassword());
            toReturn = new ResponseUser(user);
        }catch (Exception e){
            toReturn = new ResponseUser(e.getMessage());
        }
        return toReturn;
    }

    //TODO complete
    public void logout(String userName){
        try{
            articleController.logout(userName);
        }catch (Exception e){
        }
    }
}
