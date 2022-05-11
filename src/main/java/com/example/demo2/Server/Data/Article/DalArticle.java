package com.example.demo2.Server.Data.Article;

import com.example.demo2.Server.Data.Comment.DalComment;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Articles")
public class DalArticle {
    @Id
    private String title;
    private String body;

    @OneToMany(targetEntity = DalComment.class , cascade = CascadeType.ALL)
    @JoinColumn(name = "article_name" , referencedColumnName = "title")
    private List<DalComment> comments;

    public DalArticle() {
    }

    public DalArticle(String title, String body) {
        this.title = title;
        this.body = body;
        this.comments = new ArrayList<>();
    }

    public void addComment(DalComment comment) {
        comments.add(comment);
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

}
