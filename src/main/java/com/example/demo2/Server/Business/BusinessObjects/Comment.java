package com.example.demo2.Server.Business.BusinessObjects;

public class Comment {
    private int id;
    private String writer;
    private String title;
    private String commentBody;

    public Comment(String title, String commentBody, String writer, int commentId) {
        this.title = title;
        this.writer = writer;
        this.commentBody = commentBody;
        this.id = commentId;
    }

    public int getId() {
        return id;
    }

    public String getWriter() {
        return writer;
    }

    public String getTitle() {
        return title;
    }

    public String getCommentBody() {
        return commentBody;
    }
}