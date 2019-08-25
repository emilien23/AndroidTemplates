package com.emilien23.logintemplate.network.models.response;

public class BaseResponse<T> {

    private Boolean success;

    private String error;

    private String message;

    private T response;

    public BaseResponse(Boolean success, String error, String message, T response) {
        this.success = success;
        this.error = error;
        this.message = message;
        this.response = response;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }
}
