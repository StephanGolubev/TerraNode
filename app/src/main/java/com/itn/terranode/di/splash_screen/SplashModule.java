package com.itn.terranode.di.splash_screen;

import com.itn.terranode.di.scopes.AppScope;
import com.itn.terranode.domain.splash_screen.SplashInteractor;
import com.itn.terranode.domain.splash_screen.SplashInteractorImpl;

import dagger.Binds;
import dagger.Module;

@Module
public interface SplashModule {

    @Binds
    @AppScope
    SplashInteractor provideSplashScreenInteractor(SplashInteractorImpl interactor);
}
