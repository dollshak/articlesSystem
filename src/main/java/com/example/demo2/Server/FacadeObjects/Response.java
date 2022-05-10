package com.example.demo2.Server.FacadeObjects;

public abstract class Response {
    private String errorMessage;

    public Response(){
    }

    public Response(String errorMessage){
        this.errorMessage = errorMessage;
    }
}
