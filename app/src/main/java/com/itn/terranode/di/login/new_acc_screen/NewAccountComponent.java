package com.itn.terranode.di.login.new_acc_screen;

import com.itn.terranode.di.scopes.AppScope;
import com.itn.terranode.presentation.presenter.login.new_acc_screen.NewAccountPresenter;

import dagger.Subcomponent;

@AppScope
@Subcomponent(modules = NewAccountModule.class)
public interface NewAccountComponent {
    void inject(NewAccountPresenter newAccountPresenter);
}
