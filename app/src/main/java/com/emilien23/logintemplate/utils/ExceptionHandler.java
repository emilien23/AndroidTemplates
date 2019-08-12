package com.emilien23.logintemplate.utils;

public interface ExceptionHandler {

    void onException(String message);

    void onException(Throwable t);
}
