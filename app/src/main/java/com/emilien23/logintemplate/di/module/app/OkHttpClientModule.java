package com.emilien23.logintemplate.di.module.app;

import com.emilien23.logintemplate.BuildConfig;
import com.emilien23.logintemplate.utils.interceptor.AuthenticationInterceptor;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

@Module
public class OkHttpClientModule {

    private String authToken;

    public OkHttpClientModule(String authToken){
        this.authToken = authToken;
    }

    @Provides
    public OkHttpClient okHttpClient(HttpLoggingInterceptor httpLoggingInterceptor,
                                     AuthenticationInterceptor authenticationInterceptor){
        return new
                OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .addInterceptor(authenticationInterceptor)
                .build();
    }

    @Provides
    public HttpLoggingInterceptor httpLoggingInterceptor(){
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        if (BuildConfig.DEBUG)
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        return loggingInterceptor;
    }

    @Provides
    public AuthenticationInterceptor authenticationInterceptor(){
        return new AuthenticationInterceptor(authToken);
    }
}
