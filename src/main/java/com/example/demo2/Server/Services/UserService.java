package com.example.demo2.Server.Services;

import com.example.demo2.Server.Business.BusinessObjects.User;
import com.example.demo2.Server.Business.Controllers.ArticleController;
import com.example.demo2.Server.Business.Controllers.UserController;
import com.example.demo2.Server.FacadeObjects.FacadeUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserController userController;

    public UserService() {
    }

    public FacadeUser createUser(FacadeUser userToCreate) {
        FacadeUser toReturn;
        try {
            User user = userController.createUser(userToCreate.getName(),
                    userToCreate.getPassword());
            toReturn = new FacadeUser(user);
        }catch (Exception e){
            toReturn = new FacadeUser(e.getMessage());
        }
        return toReturn;
    }

    public FacadeUser getUser(String userName){
        FacadeUser toReturn;
        try {
            User user = userController.getUser(userName);
            toReturn = new FacadeUser(user);
        }catch (Exception e){
            toReturn = new FacadeUser(e.getMessage());
        }
        return toReturn;
    }

}
