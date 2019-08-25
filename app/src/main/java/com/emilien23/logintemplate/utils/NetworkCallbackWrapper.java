package com.emilien23.logintemplate.utils;

import com.emilien23.logintemplate.App;
import com.emilien23.logintemplate.network.models.response.BaseResponse;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import retrofit2.HttpException;

abstract class NetworkCallbackWrapper<T> implements Observer<BaseResponse<T>> {

    abstract void onSuccess(T result);

    @Override
    public void onNext(BaseResponse<T> baseResponse) {
        onSuccess(baseResponse.getResponse());
    }

    @Override
    public void onError(Throwable e) {
        if (e instanceof HttpException)
            App.appServiceComponent
                    .getExceptionHandler()
                    .onException(((HttpException) e).code());
        else
            App.appServiceComponent
                    .getExceptionHandler()
                    .onError(e);
    }

    @Override
    public void onComplete() { }

    @Override
    public void onSubscribe(Disposable d) { }
}
