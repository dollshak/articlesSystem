package com.example.demo2.Server.Data.Comment;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Comments")
public class DalComment {
    @Id
    private int id;
    private String title;
    private String articleName;
    private String commentBody;

    public DalComment() {
    }

    public DalComment(int id, String title, String articleName, String commentBody) {
        this.id = id;
        this.title = title;
        this.articleName = articleName;
        this.commentBody = commentBody;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public String getCommentBody() {
        return commentBody;
    }

    public void setCommentBody(String commentBody) {
        this.commentBody = commentBody;
    }
}
