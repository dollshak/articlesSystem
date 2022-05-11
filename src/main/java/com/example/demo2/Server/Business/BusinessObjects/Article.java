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

    public Comment getComment(String commentTitle) throws SystemException {
        if (!comments.containsKey(commentTitle))
            throw new SystemException("no such comment on this article");
        return comments.get(commentTitle);
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

    public DalArticle toDalObject(){
        return new DalArticle(title, body, writerName);
    }
}