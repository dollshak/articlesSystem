package com.example.demo2.Server.Business.BusinessObjects;

import com.example.demo2.Server.Data.Article.DalArticle;
import com.example.demo2.Server.SystemException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Article {
    private final String title; //unique
    private String body;
    private String writerName;
    private Map<Integer, Comment> comments;
    private Map<String, List<Integer>> stringToOffsets;
    private DalArticle dalArticle;

    public Article(String title, String body, String writerName) {
        this.title = title;
        this.body = body;
        this.writerName = writerName;
        this.comments = new HashMap<>();

        //initialize stringToOffsets
        Map<String, List<Integer>> res = new HashMap<>();
        String[] splitStringArray = body.split(" ");
        int offset = -1;
        for (String s : splitStringArray) {
            offset = body.indexOf(s, offset + 1);
            if (res.containsKey(s))
                res.get(s).add(offset);
            else {
                List<Integer> offsets = new ArrayList<>();
                offsets.add(offset);
                res.put(s, offsets);
            }
        }
        this.stringToOffsets = res;
    }


    public Comment createComment(String title, String comment, String userName, int id) throws SystemException {
        Comment newComment = new Comment(title, comment, userName,id, this.getTitle());
        dalArticle.addComment(newComment.getDalObject());
        comments.put(newComment.getId(), newComment);
        return newComment;
    }

    public DalArticle getDalObject() {
        if (dalArticle == null)
            dalArticle = new DalArticle(title, body);
        return dalArticle;
    }

    public List<Integer> getOffsets(String str) {
        if (!stringToOffsets.containsKey(str))
            return null;
        return stringToOffsets.get(str);
    }
    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public String getWriterName() {
        return writerName;
    }

    public Map<Integer, Comment> getComments() {
        return comments;
    }

}