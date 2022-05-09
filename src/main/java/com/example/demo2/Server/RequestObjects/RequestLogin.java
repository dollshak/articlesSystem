package com.example.demo2.Server.RequestObjects;

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

    public RequestLogin deserialize(String jsonUser){
        RequestLogin toReturn = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            Map<String, Object> map = mapper.readValue(jsonUser, Map.class);
            toReturn = (RequestLogin) map.get(0);
        }catch (Exception e){}
        return toReturn;
    }
}
