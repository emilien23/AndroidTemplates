package com.emilien23.logintemplate;

import android.app.Application;
import android.content.Intent;
import android.widget.Toast;

import com.emilien23.logintemplate.ui.LoginActivity;
import com.emilien23.logintemplate.utils.ExceptionHandler;
import com.emilien23.logintemplate.utils.HttpExceptionHandler;

public class App extends Application implements HttpExceptionHandler.HttpExceptionCallback {


    private String MESSAGE_UNAUTHORIZED = getResources().getString(R.string.message_unauthorized);
    private String MESSAGE_FORBIDDEN = getResources().getString(R.string.message_forbidden);

    public static ExceptionHandler exceptionHandler;

    @Override
    public void onCreate() {
        super.onCreate();
        exceptionHandler = new HttpExceptionHandler(this);
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
