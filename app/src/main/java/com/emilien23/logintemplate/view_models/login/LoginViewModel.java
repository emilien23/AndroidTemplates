package com.emilien23.logintemplate.view_models.login;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.emilien23.logintemplate.App;
import com.emilien23.logintemplate.di.component.DaggerLoginActivityComponent;
import com.emilien23.logintemplate.di.component.LoginActivityComponent;
import com.emilien23.logintemplate.network.api.NetworkService;
import com.emilien23.logintemplate.network.models.auth.Login;
import com.emilien23.logintemplate.network.models.auth.Token;
import com.emilien23.logintemplate.repositories.auth.AuthRepository;
import com.emilien23.logintemplate.repositories.auth.AuthRepositoryImpl;
import com.emilien23.logintemplate.utils.NetworkCallbackWrapper;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class LoginViewModel extends ViewModel {

    private final AuthRepository repository;
    private CompositeDisposable disposables;

    MediatorLiveData<Token> tokenData;

    @Inject
    public LoginViewModel(AuthRepository repository) {
        disposables = new CompositeDisposable();
        tokenData = new MediatorLiveData<>();
        this.repository = repository;
    }

    public LiveData<Token> getTokenData(){
        return tokenData;
    }

    public void login(Login login){
        disposables.add(repository.login(login)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeWith(new NetworkCallbackWrapper<Token>(){
            @Override
            public void onSuccess(Token result) {
                tokenData.setValue(result);
            }
        }));
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if(disposables != null){
            disposables.clear();
            disposables = null;
        }
    }
}
