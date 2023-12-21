package org.uplift.exception;

public class UserDoesNotExistException extends Exception{
    public UserDoesNotExistException(String str){
        super(str);
    }
}
