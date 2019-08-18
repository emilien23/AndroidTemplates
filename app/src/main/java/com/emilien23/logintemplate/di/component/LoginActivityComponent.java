package com.emilien23.logintemplate.di.component;

import com.emilien23.logintemplate.di.annotation.LoginActivityScope;
import com.emilien23.logintemplate.network.NetworkService;

import dagger.Component;

@Component(dependencies = AppServiceComponent.class)
@LoginActivityScope
public interface LoginActivityComponent {
    NetworkService getAppService();
}
