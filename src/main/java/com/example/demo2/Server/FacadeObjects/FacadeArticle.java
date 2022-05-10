package com.example.demo2.Server.FacadeObjects;

import com.example.demo2.Server.Business.BusinessObjects.Article;
import com.example.demo2.Server.Business.BusinessObjects.Comment;
import java.util.HashMap;
import java.util.Map;

public class FacadeArticle extends Response {
    private String title;
    private String body;
    private String writerName;
    private Map<String, FacadeComment> comments;

    public FacadeArticle(){
        this.comments = new HashMap<>();
    }

    public FacadeArticle(Article article) {
        this.title = article.getTitle();
        this.body = article.getBody();
        this.writerName = article.getWriterName();
        this.comments = new HashMap<>();
        Map<String, Comment> businessComments = article.getComments();
        for (Map.Entry<String, Comment> entry : businessComments.entrySet()){
            FacadeComment responseComment = new FacadeComment(entry.getValue());
            this.comments.put(entry.getKey(), responseComment);
        }
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

    public Map<String, FacadeComment> getComments() {
        return comments;
    }

    public void setComments(Map<String, FacadeComment> comments) {
        this.comments = comments;
    }
}