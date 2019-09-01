package com.emilien23.logintemplate.di.module;

import com.emilien23.logintemplate.repositories.auth.AuthRepository;
import com.emilien23.logintemplate.repositories.auth.AuthRepositoryImpl;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class LoginModule {

    @Binds
    public abstract AuthRepository bindAuthRepository(AuthRepositoryImpl authRepository);
}
