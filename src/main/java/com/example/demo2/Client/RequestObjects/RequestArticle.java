package com.example.demo2.Client.RequestObjects;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

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

    public com.example.demo2.Server.RequestObjects.RequestArticle deserialize(String jsonArticle) {
        com.example.demo2.Server.RequestObjects.RequestArticle toReturn = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            Map<String, Object> map = mapper.readValue(jsonArticle, Map.class);
            toReturn = (com.example.demo2.Server.RequestObjects.RequestArticle) map.get(0);
        }catch (Exception e){}
        return toReturn;
    }
}