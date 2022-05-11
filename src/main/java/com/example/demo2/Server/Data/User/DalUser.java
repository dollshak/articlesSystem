package com.example.demo2.Server.Data.User;

import com.example.demo2.Server.Data.Article.DalArticle;
import com.example.demo2.Server.Data.Comment.DalComment;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Users")
public class DalUser {
    @Id
    private String name;
    private String password;
    @OneToMany(targetEntity = DalArticle.class , cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id" , referencedColumnName = "name")
    private List<DalArticle> articles;
    @OneToMany(targetEntity = DalComment.class , cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id" , referencedColumnName = "name")
    private List<DalComment> comments;

    public DalUser(String name, String password) {
        this.name = name;
        this.password = password;
        this.articles = new ArrayList<>();
        this.comments = new ArrayList<>();
    }

    public void addArticle(DalArticle article){
        articles.add(article);
    }

    public void addComment(DalComment comment) {
        comments.add(comment);
    }

    public DalUser() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<DalArticle> getArticles() {
        return articles;
    }

    public void setArticles(List<DalArticle> articles) {
        this.articles = articles;
    }

    public List<DalComment> getComments() {
        return comments;
    }

    public void setComments(List<DalComment> comments) {
        this.comments = comments;
    }


}
