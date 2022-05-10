package com.example.demo2.Server.Services;

import com.example.demo2.Server.Business.BusinessObjects.User;
import com.example.demo2.Server.Business.Controllers.ArticleController;
import com.example.demo2.Server.RequestObjects.RequestLogin;
import com.example.demo2.Server.RequestObjects.RequestUser;
import com.example.demo2.Server.FacadeObjects.FacadeUser;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private ArticleController articleController;

    public UserService() {
        articleController = ArticleController.getInstance();
    }

    public FacadeUser createUser(RequestUser userToCreate) {
        FacadeUser toReturn;
        try {
            User user = articleController.createUser(userToCreate.getName(),
                    userToCreate.getPassword(),
                    userToCreate.getValidatePassword());
            toReturn = new FacadeUser(user);
        }catch (Exception e){
            toReturn = new FacadeUser(e.getMessage());
        }
        return toReturn;
    }

    public FacadeUser getUser(String userName){
        FacadeUser toReturn;
        try {
            User user = articleController.getUser(userName);
            toReturn = new FacadeUser(user);
        }catch (Exception e){
            toReturn = new FacadeUser(e.getMessage());
        }
        return toReturn;
    }

    public FacadeUser login(RequestLogin requestUser){
        FacadeUser toReturn;
        try {
            User user = articleController.login(requestUser.getName(),
                    requestUser.getPassword());
            toReturn = new FacadeUser(user);
        }catch (Exception e){
            toReturn = new FacadeUser(e.getMessage());
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
