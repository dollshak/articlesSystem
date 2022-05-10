package com.example.demo2.Client.RequestObjects;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class RequestComment {
    private String writer;
    private String title;
    private String commentBody;
    private String articleName;

    public RequestComment() {
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

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public com.example.demo2.Server.RequestObjects.RequestComment deserialize(String jsonComment) {
        com.example.demo2.Server.RequestObjects.RequestComment toReturn = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            Map<String, Object> map = mapper.readValue(jsonComment, Map.class);
            toReturn = (com.example.demo2.Server.RequestObjects.RequestComment) map.get(0);
        }catch (Exception e){}
        return toReturn;
    }
}
