package com.emilien23.logintemplate.repositories.auth;

import com.emilien23.logintemplate.network.models.auth.Login;
import com.emilien23.logintemplate.network.models.auth.Token;
import com.emilien23.logintemplate.network.models.response.BaseResponse;

import io.reactivex.Observable;

public interface AuthRepository {


    Observable<BaseResponse<Token>> login(Login login);

    Observable<BaseResponse<String>> checkTokenValid(Token token);
}
