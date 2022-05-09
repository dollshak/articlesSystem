package com.example.demo2.Server.ResponseObjects;

import com.example.demo2.Server.Business.BusinessObjects.Comment;

public class ResponseComment extends Response{
    private int id;
    private String writer;
    private String title;
    private String commentBody;

    public ResponseComment(){}
    public ResponseComment(Comment comment) {
        this.id = comment.getId();
        this.writer = comment.getWriter();
        this.title = comment.getTitle();
        this.commentBody = comment.getCommentBody();
    }

    public ResponseComment(String message) {
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
}