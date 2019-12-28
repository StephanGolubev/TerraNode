package com.itn.terranode.di.login.login_screen;

import com.itn.terranode.di.scopes.AppScope;
import com.itn.terranode.presentation.presenter.login.login_screen.LoginPresenter;

import dagger.Subcomponent;

@AppScope
@Subcomponent(modules = LoginModule.class)
public interface LoginComponent {
    void inject(LoginPresenter loginPresenter);
}
