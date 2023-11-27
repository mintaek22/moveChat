package com.movechat.chat.exception;

import org.springframework.http.HttpStatus;

public abstract class ApplicationException extends RuntimeException{

    public ApplicationException(String message){
        super(message);
    }

    public abstract HttpStatus status();

}
