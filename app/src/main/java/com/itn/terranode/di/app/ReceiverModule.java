package com.itn.terranode.di.app;

import com.itn.terranode.di.scopes.AppScope;
import com.itn.terranode.domain.broadcast.ReceiverInteractor;
import com.itn.terranode.domain.broadcast.ReceiverInteractorImpl;

import dagger.Binds;
import dagger.Module;

@Module
public interface ReceiverModule {
    @Binds
    @AppScope
    ReceiverInteractor provideReceiverInteractor(ReceiverInteractorImpl interactor);
}
