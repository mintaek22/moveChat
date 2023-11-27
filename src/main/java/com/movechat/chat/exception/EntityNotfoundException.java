package com.movechat.chat.exception;

import org.springframework.http.HttpStatus;

public class EntityNotfoundException extends ApplicationException{

    @Override
    public HttpStatus status() {
        return HttpStatus.NOT_FOUND;
    }

    public EntityNotfoundException(String message) {
        super(message);
    }

}
