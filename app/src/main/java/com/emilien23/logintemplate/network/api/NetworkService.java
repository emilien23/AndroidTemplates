package com.emilien23.logintemplate.network.api;

import com.emilien23.logintemplate.network.models.auth.Login;
import com.emilien23.logintemplate.network.models.registration.RegistrationData;
import com.emilien23.logintemplate.network.models.auth.Token;
import com.emilien23.logintemplate.network.models.response.BaseResponse;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface NetworkService {

    @GET
    Observable<BaseResponse<String>> isTokenValid();

    @POST
    Observable<BaseResponse<Token>> login(@Body Login login);

    @POST
    Observable<BaseResponse<Token>> signUp(@Body RegistrationData registrationData);
}
