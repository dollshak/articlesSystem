package com.example.demo2.Server.Business.Controllers;

import com.example.demo2.Server.Business.BusinessObjects.User;
import com.example.demo2.Server.SystemException;

import java.util.HashMap;
import java.util.Map;

public class UserController {
    private Map<String, User> users;
//    private User loggedIn;
    private static UserController instance;

    public static UserController getInstance() {
        if (instance == null)
            instance = new UserController();
        return instance;
    }

    private UserController(){
        users = new HashMap<>();
    }

    public User createUser(String name, String password) throws SystemException {
        if (users.containsKey(name))
            throw new SystemException("username already exists in the system, please choose another username");
        User newUser = new User(name, password);
        users.put(name, newUser);
        return newUser;
    }

    public User getUser(String name) throws SystemException {
        if (!users.containsKey(name))
            throw new SystemException("no such user");
        return users.get(name);
    }

//    public User getLoggedInUser(String userName) throws SystemException {
//        if (!users.containsKey(userName))
//            throw new SystemException("no such user");
//        if (loggedIn.getName() != userName)
//            throw new SystemException("user is not logged in");
//        return loggedIn;
//    }

}