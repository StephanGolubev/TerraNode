package com.itn.terranode.di.splash_screen;

import com.itn.terranode.di.scopes.AppScope;
import com.itn.terranode.presentation.presenter.splash_screen.SplashScreenPresenter;

import dagger.Subcomponent;

@AppScope
@Subcomponent(modules = SplashModule.class)
public interface SplashComponent {
    void inject(SplashScreenPresenter splashScreenPresenter);
}
