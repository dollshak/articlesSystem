package com.example.demo2.Client.RequestObjects;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class RequestUser {
    private String name;
    private String password;
    private String validatePassword;

    public RequestUser() {
    }

    public RequestUser(String name, String password, String validatePassword) {
        this.name = name;
        this.password = password;
        this.validatePassword = validatePassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getValidatePassword() {
        return validatePassword;
    }

    public void setValidatePassword(String validatePassword) {
        this.validatePassword = validatePassword;
    }

    public com.example.demo2.Server.RequestObjects.RequestUser deserialize(String jsonUser){
        com.example.demo2.Server.RequestObjects.RequestUser toReturn = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            Map<String, Object> map = mapper.readValue(jsonUser, Map.class);
            toReturn = (com.example.demo2.Server.RequestObjects.RequestUser) map.get(0);
        }catch (Exception e){}
        return toReturn;
    }
}