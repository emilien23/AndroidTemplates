package com.emilien23.logintemplate.utils.exception;

public interface ExceptionHandler {

    void onException(String message);

    void onException(Throwable t);
}
