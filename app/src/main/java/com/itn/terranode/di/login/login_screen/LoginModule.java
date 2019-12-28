package com.itn.terranode.di.login.login_screen;

import com.itn.terranode.di.scopes.AppScope;
import com.itn.terranode.domain.login.login_screen.LoginInteractor;
import com.itn.terranode.domain.login.login_screen.LoginInteractorImpl;

import dagger.Binds;
import dagger.Module;

@Module
public interface LoginModule {

    @Binds
    @AppScope
    LoginInteractor provideLoginInteractor(LoginInteractorImpl loginInteractor);
}
