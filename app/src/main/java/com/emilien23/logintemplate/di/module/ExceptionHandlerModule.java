package com.emilien23.logintemplate.di.module;

import com.emilien23.logintemplate.di.annotation.AppServiceScope;
import com.emilien23.logintemplate.utils.exception.ExceptionHandler;
import com.emilien23.logintemplate.utils.exception.HttpExceptionHandler;

import dagger.Module;
import dagger.Provides;

@Module
public class ExceptionHandlerModule {

    private final HttpExceptionHandler.HttpExceptionCallback callback;

    public ExceptionHandlerModule(HttpExceptionHandler.HttpExceptionCallback callback){
        this.callback = callback;
    }

    @Provides
    @AppServiceScope
    public ExceptionHandler exceptionHandler(){
        return new HttpExceptionHandler(callback);
    }
}
