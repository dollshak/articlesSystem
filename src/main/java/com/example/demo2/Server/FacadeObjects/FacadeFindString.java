package com.example.demo2.Server.FacadeObjects;

import java.util.List;

public class FacadeFindString extends Response {
    private String article_id;
    private List<Integer> offsets;

    public FacadeFindString() {
    }

    public FacadeFindString(String message){
        super(message);
    }

    public FacadeFindString(String article_id, List<Integer> offsets) {
        this.article_id = article_id;
        this.offsets = offsets;
    }

    public String getArticle_id() {
        return article_id;
    }

    public void setArticle_id(String article_id) {
        this.article_id = article_id;
    }

    public List<Integer> getOffsets() {
        return offsets;
    }

    public void setOffsets(List<Integer> offsets) {
        this.offsets = offsets;
    }
}
