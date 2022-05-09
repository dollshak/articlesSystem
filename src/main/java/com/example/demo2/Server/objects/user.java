package com.example.demo2.Server.objects;

public class user {
    private String name;
    private String password;

    public user(String name, String password) {
        this.name = name;
        this.password = password;
    }
    public user(){}

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


}
