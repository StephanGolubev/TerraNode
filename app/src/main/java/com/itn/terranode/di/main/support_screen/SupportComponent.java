package com.itn.terranode.di.main.support_screen;

import com.itn.terranode.di.scopes.AppScope;
import com.itn.terranode.presentation.presenter.main.support_screen.SupportPresenter;

import dagger.Subcomponent;

@AppScope
@Subcomponent(modules = SupportModule.class)
public interface SupportComponent {
    void inject(SupportPresenter supportPresenter);
}