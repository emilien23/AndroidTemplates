package com.emilien23.logintemplate.di.module.view_model;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.emilien23.logintemplate.di.util.ViewModelKey;
import com.emilien23.logintemplate.utils.factories.ViewModelFactory;
import com.emilien23.logintemplate.view_models.login.LoginViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel.class)
    abstract ViewModel bindDetailsViewModel(LoginViewModel loginViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory daggerViewModelFactory);
}
