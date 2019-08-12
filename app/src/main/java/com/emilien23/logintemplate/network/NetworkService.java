package com.emilien23.logintemplate.network;

import com.emilien23.logintemplate.network.models.Login;
import com.emilien23.logintemplate.network.models.RegistrationData;
import com.emilien23.logintemplate.network.models.Token;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface NetworkService {

    @GET
    Observable<String> isTokenValid();

    @POST
    Observable<Token> login(@Body Login login);

    @POST
    Observable<Token> signUp(@Body RegistrationData registrationData);
}
