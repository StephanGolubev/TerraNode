package com.itn.terranode.di.login.new_acc_screen;

import com.itn.terranode.di.scopes.AppScope;
import com.itn.terranode.domain.login.login_screen.LoginInteractorImpl;
import com.itn.terranode.domain.login.new_acc_screen.NewAccountInteractor;
import com.itn.terranode.domain.login.new_acc_screen.NewAccountInteractorImpl;

import dagger.Binds;
import dagger.Module;

@Module
interface NewAccountModule {

    @Binds
    @AppScope
    NewAccountInteractor provideLoginInteractor(NewAccountInteractorImpl loginInteractor);
}
