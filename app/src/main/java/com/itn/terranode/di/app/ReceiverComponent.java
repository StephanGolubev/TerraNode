package com.itn.terranode.di.app;

import com.itn.terranode.di.login.login_screen.LoginModule;
import com.itn.terranode.di.scopes.AppScope;
import com.itn.terranode.presentation.view.broadcast.RefreshTokenReceiver;

import dagger.Subcomponent;

@AppScope
@Subcomponent(modules = ReceiverModule.class)
public interface ReceiverComponent {
    void inject(RefreshTokenReceiver receiver);
}