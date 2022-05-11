package com.example.demo2.Server.Business.BusinessObjects;

import com.example.demo2.Server.Data.Article.DalArticle;
import com.example.demo2.Server.SystemException;

import java.util.HashMap;
import java.util.Map;

public class Article {
    private final String title; //unique
    private String body;
    private String writerName;
    private Map<Integer, Comment> comments;
    private DalArticle dalArticle;

    public Article(String title, String body, String writerName) {
        this.title = title;
        this.body = body;
        this.writerName = writerName;
        this.comments = new HashMap<>();
    }

    public Comment createComment(String title, String comment, String userName, int id) throws SystemException {
        Comment newComment = new Comment(title, comment, userName,id, this.getTitle());
        comments.put(newComment.getId(), newComment);
        return newComment;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public String getWriterName() {
        return writerName;
    }

    public Map<Integer, Comment> getComments() {
        return comments;
    }

    public DalArticle getDalObject() {
        if (dalArticle == null)
            dalArticle = new DalArticle(title, body);
        return dalArticle;
    }
}