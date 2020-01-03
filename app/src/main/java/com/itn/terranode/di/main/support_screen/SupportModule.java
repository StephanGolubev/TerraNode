package com.itn.terranode.di.main.support_screen;

import com.itn.terranode.di.scopes.AppScope;
import com.itn.terranode.domain.main.support_screen.SupportInteractor;
import com.itn.terranode.domain.main.support_screen.SupportInteractorImpl;

import dagger.Binds;
import dagger.Module;

@Module
public interface SupportModule {

    @Binds
    @AppScope
    SupportInteractor provideSupportInteractor(SupportInteractorImpl interactor);
}