package com.example.demo2.Server.FacadeObjects;

import com.example.demo2.Server.Business.BusinessObjects.Article;
import com.example.demo2.Server.Business.BusinessObjects.Comment;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FacadeArticle extends Response {
    private String title;
    private String body;
    private String writerName;
    private List<Integer> comments;

    public FacadeArticle(){
        this.comments = new ArrayList<>();
    }

    public FacadeArticle(Article article) {
        this.title = article.getTitle();
        this.body = article.getBody();
        this.writerName = article.getWriterName();
        Map<Integer, Comment> businessComments = article.getComments();
        this.comments = new ArrayList<>(businessComments.keySet());
    }

    public FacadeArticle(String message) {
        super(message);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getWriterName() {
        return writerName;
    }

    public void setWriterName(String writerName) {
        this.writerName = writerName;
    }

    public List<Integer> getComments() {
        return comments;
    }

    public void setComments(List<Integer> comments) {
        this.comments = comments;
    }
}