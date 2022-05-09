package com.example.demo2.Server;

public class SystemException extends Exception {
    private final String message;
    private final Object addOn;

    public SystemException(String mess, Object add){
        message=mess;
        addOn=add;
    }

    public SystemException(String mess){
        message=mess;
        addOn=null;
    }
    public SystemException( Object add){
        message="";
        addOn=add;
    }
    public boolean hasObj(){ return addOn!=null;}

    public String getMessage() {return message;}

    public Object getObj() {return addOn;}
}
