package com.emilien23.logintemplate.di.component;

import com.emilien23.logintemplate.di.annotation.LoginActivityScope;
import com.emilien23.logintemplate.di.module.LoginModule;
import com.emilien23.logintemplate.di.module.view_model.ViewModelModule;
import com.emilien23.logintemplate.ui.LoginActivity;

import dagger.Component;

@Component(dependencies = AppServiceComponent.class,
        modules = {ViewModelModule.class, LoginModule.class})
@LoginActivityScope
public interface LoginActivityComponent {
    void inject(LoginActivity loginActivity);
}
