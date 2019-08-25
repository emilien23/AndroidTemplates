package com.emilien23.logintemplate;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.widget.Toast;

import com.emilien23.logintemplate.di.component.AppServiceComponent;
import com.emilien23.logintemplate.di.component.DaggerAppServiceComponent;
import com.emilien23.logintemplate.di.module.context.ContextModule;
import com.emilien23.logintemplate.di.module.ExceptionHandlerModule;
import com.emilien23.logintemplate.ui.LoginActivity;
import com.emilien23.logintemplate.utils.exception.HttpExceptionHandler;

public class App extends Application implements HttpExceptionHandler.HttpExceptionCallback {

    public static App instance;
    public static AppServiceComponent appServiceComponent;

    private String MESSAGE_UNAUTHORIZED = getResources().getString(R.string.message_unauthorized);
    private String MESSAGE_FORBIDDEN = getResources().getString(R.string.message_forbidden);

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        appServiceComponent = DaggerAppServiceComponent.builder()
                .exceptionHandlerModule(new ExceptionHandlerModule(this))
                .contextModule(new ContextModule(this))
                .build();
    }

    @Override
    public void onAuthorized() {
        Toast.makeText(this, MESSAGE_UNAUTHORIZED, Toast.LENGTH_SHORT).show();
        startLogin();
    }

    @Override
    public void onForbidden() {
        Toast.makeText(this, MESSAGE_FORBIDDEN, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUnknown(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void startLogin(){
        startActivity(new Intent(this, LoginActivity.class));
    }
}
