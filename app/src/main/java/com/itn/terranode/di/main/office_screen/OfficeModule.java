package com.itn.terranode.di.main.office_screen;

import com.itn.terranode.di.scopes.AppScope;
import com.itn.terranode.domain.main.office_screen.OfficeInteractor;
import com.itn.terranode.domain.main.office_screen.OfficeInteractorImpl;

import dagger.Binds;
import dagger.Module;

@Module
public interface OfficeModule {

    @Binds
    @AppScope
    OfficeInteractor provideOfficeInteractor(OfficeInteractorImpl officeInteractor);
}
