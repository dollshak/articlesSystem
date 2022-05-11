package com.example.demo2.Server.Data.User;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class DalUser {
    @Id
    private String name;
    private String password;

    public DalUser(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public DalUser() {
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
}
