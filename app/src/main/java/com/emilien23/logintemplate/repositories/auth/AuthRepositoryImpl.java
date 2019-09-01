package com.emilien23.logintemplate.repositories.auth;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.emilien23.logintemplate.network.api.NetworkService;
import com.emilien23.logintemplate.network.models.auth.Login;
import com.emilien23.logintemplate.network.models.auth.Token;
import com.emilien23.logintemplate.network.models.response.BaseResponse;

import javax.inject.Inject;

import io.reactivex.Observable;

public class AuthRepositoryImpl implements AuthRepository {

    private final NetworkService networkService;

    @Inject
    public AuthRepositoryImpl(NetworkService service){
        networkService = service;
    }

    @Override
    public Observable<BaseResponse<Token>> login(Login login) {
        return networkService.login(login);
    }

    @Override
    public Observable<BaseResponse<String>> checkTokenValid(Token token) {
        return networkService.isTokenValid();
    }

}
