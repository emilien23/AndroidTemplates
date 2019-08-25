package com.emilien23.logintemplate.utils.exception;

public class HttpExceptionHandler implements ExceptionHandler {

    HttpExceptionCallback callback;

    public HttpExceptionHandler(HttpExceptionCallback callback){
        this.callback = callback;
    }

    public void onException(Integer code){
        if(code.equals(HttpResponseCode.UNAUTHORIZED)){
            callback.onAuthorized();
        }
        if(code.equals(HttpResponseCode.FORBIDDEN)){
            callback.onForbidden();
        }
    }

    public void onException(String message){
        callback.onUnknown(message);
    }

    public void onError(Throwable t){
        callback.onUnknown(t.getMessage());
    }

    public interface HttpExceptionCallback{

        void onAuthorized();

        void onForbidden();

        void onUnknown(String message);

    }

}
