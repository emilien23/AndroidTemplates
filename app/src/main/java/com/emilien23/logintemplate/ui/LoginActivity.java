package com.emilien23.logintemplate.ui;

import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.emilien23.logintemplate.App;
import com.emilien23.logintemplate.R;
import com.emilien23.logintemplate.di.component.DaggerLoginActivityComponent;
import com.emilien23.logintemplate.di.component.LoginActivityComponent;
import com.emilien23.logintemplate.utils.factories.ViewModelFactory;
import com.emilien23.logintemplate.view_models.login.LoginViewModel;

import javax.inject.Inject;

import butterknife.BindView;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.btnLogin)
    Button btnLogin;
    @BindView(R.id.btnToRegistr)
    Button btnRegistr;
    @BindView(R.id.edLogin)
    Button edLogin;
    @BindView(R.id.edPassword)
    Button edPassword;

    @Inject
    ViewModelFactory viewModelFactory;

    private LoginViewModel loginViewModel;
    private LoginActivityComponent loginActivityComponent;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loginActivityComponent = DaggerLoginActivityComponent
                .builder()
                .appServiceComponent(App.appServiceComponent)
                .build();

        loginActivityComponent.inject(this);

        loginViewModel = ViewModelProviders
                .of(this, viewModelFactory)
                .get(LoginViewModel.class);
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
