package com.example.demo2.Server.RequestObjects;

public class RequestArticle {
    private String title;
    private String body;
    private String writerName;

    public RequestArticle() {
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
