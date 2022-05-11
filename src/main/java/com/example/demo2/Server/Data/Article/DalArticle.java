package com.example.demo2.Server.Data.Article;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DalArticle {
    @Id
    private String title;
    private String body;
    private String writerName;

    public DalArticle() {
    }

    public DalArticle(String title, String body, String writerName) {
        this.title = title;
        this.body = body;
        this.writerName = writerName;
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
}
