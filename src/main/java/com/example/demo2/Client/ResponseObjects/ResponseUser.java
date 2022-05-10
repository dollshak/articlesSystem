package com.example.demo2.Client.ResponseObjects;

import java.util.List;
import java.util.Map;

public class ResponseUser {
    private String name;
    private List<String> articles;
    private Map<String, String> comments; //title -> comment

    public ResponseUser(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getArticles() {
        return articles;
    }

    public void setArticles(List<String> articles) {
        this.articles = articles;
    }

    public Map<String, String> getComments() {
        return comments;
    }

    public void setComments(Map<String, String> comments) {
        this.comments = comments;
    }
}
