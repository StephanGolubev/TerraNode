package com.itn.terranode.di.main.office_screen;

import com.itn.terranode.di.scopes.AppScope;
import com.itn.terranode.presentation.presenter.main.office_screen.OfficePresenter;

import dagger.Subcomponent;

@AppScope
@Subcomponent(modules = OfficeModule.class)
interface OfficeComponent {
    void inject(OfficePresenter officePresenter);
}
