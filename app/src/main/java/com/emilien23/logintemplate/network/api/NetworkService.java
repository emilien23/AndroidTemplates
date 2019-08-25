package com.emilien23.logintemplate.network.api;

import com.emilien23.logintemplate.network.models.auth.Login;
import com.emilien23.logintemplate.network.models.registration.RegistrationData;
import com.emilien23.logintemplate.network.models.auth.Token;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface NetworkService {

    @GET
    Observable<Response<String>> isTokenValid();

    @POST
    Observable<Response<Token>> login(@Body Login login);

    @POST
    Observable<Response<Token>> signUp(@Body RegistrationData registrationData);
}
