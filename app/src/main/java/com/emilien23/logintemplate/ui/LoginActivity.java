package com.emilien23.logintemplate.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.emilien23.logintemplate.App;
import com.emilien23.logintemplate.di.component.DaggerLoginActivityComponent;
import com.emilien23.logintemplate.di.component.LoginActivityComponent;
import com.emilien23.logintemplate.network.api.NetworkService;

public class LoginActivity extends AppCompatActivity {



    LoginActivityComponent loginActivityComponent;
    NetworkService networkService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loginActivityComponent = DaggerLoginActivityComponent
                .builder()
                .appServiceComponent(App.appServiceComponent)
                .build();

        networkService = loginActivityComponent.getAppService();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
