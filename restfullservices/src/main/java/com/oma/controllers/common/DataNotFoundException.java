package com.oma.controllers.common;

/**
 * Created by dev on 02/11/16.
 */
public class DataNotFoundException extends Throwable {
    public DataNotFoundException(String message){
        super(message);
    }
    public DataNotFoundException(String message, Throwable t){
        super(message,t);
    }
    public DataNotFoundException(Throwable t){
        super(t);
    }

}
