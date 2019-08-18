package com.emilien23.logintemplate.network;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AuthenticationInterceptor implements Interceptor {

    private String token;

    public AuthenticationInterceptor(String token){
        this.token = token;
    }
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        Request request = original.newBuilder().header("Authorization", token).build();
        return chain.proceed(request);
    }
}
