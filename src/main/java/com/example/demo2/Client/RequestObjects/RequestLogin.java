package com.example.demo2.Client.RequestObjects;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class RequestLogin {
    private String name;
    private String password;

    public RequestLogin() {
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

    public com.example.demo2.Server.RequestObjects.RequestLogin deserialize(String jsonUser){
        com.example.demo2.Server.RequestObjects.RequestLogin toReturn = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            Map<String, Object> map = mapper.readValue(jsonUser, Map.class);
            toReturn = (com.example.demo2.Server.RequestObjects.RequestLogin) map.get(0);
        }catch (Exception e){}
        return toReturn;
    }
}
