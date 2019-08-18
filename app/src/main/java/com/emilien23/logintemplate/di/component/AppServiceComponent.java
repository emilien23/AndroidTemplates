package com.emilien23.logintemplate.di.component;

import com.emilien23.logintemplate.di.annotation.AppServiceScope;
import com.emilien23.logintemplate.di.module.context.ContextModule;
import com.emilien23.logintemplate.di.module.ExceptionHandlerModule;
import com.emilien23.logintemplate.di.module.app.AppServiceModule;
import com.emilien23.logintemplate.network.NetworkService;
import com.emilien23.logintemplate.utils.exception.ExceptionHandler;

import dagger.Component;

@AppServiceScope
@Component(modules = {AppServiceModule.class, ExceptionHandlerModule.class, ContextModule.class})
public interface AppServiceComponent {
    NetworkService gerAppService();
    ExceptionHandler getExceptionHandler();
}
