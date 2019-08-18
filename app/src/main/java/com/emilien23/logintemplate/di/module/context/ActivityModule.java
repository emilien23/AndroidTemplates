package com.emilien23.logintemplate.di.module.context;

import android.app.Activity;
import android.content.Context;

import com.emilien23.logintemplate.di.annotation.AppServiceScope;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private final Context context;

    ActivityModule(Activity context){
        this.context = context;
    }

    @Named("activity_context")
    @AppServiceScope
    @Provides
    public Context context(){ return context; }
}
