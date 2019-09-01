package com.emilien23.logintemplate.utils;

import com.emilien23.logintemplate.App;
import com.emilien23.logintemplate.network.models.response.BaseResponse;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import retrofit2.HttpException;

public abstract class NetworkCallbackWrapper<T> extends DisposableObserver<BaseResponse<T>> {

    public abstract void onSuccess(T result);

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
}
