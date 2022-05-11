package com.example.demo2.Server.Business.BusinessObjects;

import com.example.demo2.Server.Data.Comment.DalComment;

public class Comment {
    private int id;
    private String writer;
    private String title;
    private String articleName;
    private String commentBody;

    public Comment(String title, String commentBody, String writer,
                   int commentId, String articleName) {
        this.title = title;
        this.writer = writer;
        this.commentBody = commentBody;
        this.id = commentId;
        this.articleName = articleName;
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

    public String getArticleName() {
        return articleName;
    }

    public DalComment toDalObject(){
        return new DalComment(id, writer, title, articleName, commentBody);
    }
}
