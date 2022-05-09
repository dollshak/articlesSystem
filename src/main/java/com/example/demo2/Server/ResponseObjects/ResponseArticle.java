package com.example.demo2.Server.ResponseObjects;

import com.example.demo2.Server.Business.BusinessObjects.Article;
import com.example.demo2.Server.Business.BusinessObjects.Comment;

import java.util.HashMap;
import java.util.Map;

public class ResponseArticle extends Response {
    private String title;
    private String body;
    private String writerName;
    private Map<String, ResponseComment> comments;

    public ResponseArticle(){
        this.comments = new HashMap<>();
    }

    public ResponseArticle(Article article) {
        this.title = article.getTitle();
        this.body = article.getBody();
        this.writerName = article.getWriterName();
        this.comments = new HashMap<>();
        Map<String, Comment> businessComments = article.getComments();
        for (Map.Entry<String, Comment> entry : businessComments.entrySet()){
            ResponseComment responseComment = new ResponseComment(entry.getValue());
            this.comments.put(entry.getKey(), responseComment);
        }
    }

    public ResponseArticle(String message) {
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

    public Map<String, ResponseComment> getComments() {
        return comments;
    }

    public void setComments(Map<String, ResponseComment> comments) {
        this.comments = comments;
    }
}