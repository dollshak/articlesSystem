package com.example.demo2.Server.FacadeObjects;

import com.example.demo2.Server.Business.BusinessObjects.Comment;

public class FacadeComment extends Response{
    private int id;
    private String writer;
    private String title;
    private String article;
    private String commentBody;

    public FacadeComment(){}
    public FacadeComment(Comment comment) {
        this.id = comment.getId();
        this.writer = comment.getWriter();
        this.title = comment.getTitle();
        this.commentBody = comment.getCommentBody();
        this.article = comment.getArticleName();
    }

    public FacadeComment(String message) {
        super(message);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCommentBody() {
        return commentBody;
    }

    public void setCommentBody(String commentBody) {
        this.commentBody = commentBody;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }
}