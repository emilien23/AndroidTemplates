package com.emilien23.logintemplate.repositories.user;

import androidx.lifecycle.LiveData;

import com.emilien23.logintemplate.network.models.auth.Token;
import com.emilien23.logintemplate.network.models.registration.RegistrationData;

public interface UserRepository  {

    LiveData<Token> createUser(RegistrationData registrationData);
}
