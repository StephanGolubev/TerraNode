package com.itn.terranode.di.main.chat_screen;

import com.itn.terranode.di.scopes.AppScope;
import com.itn.terranode.presentation.presenter.main.chat_screen.ChatPresenter;

import dagger.Subcomponent;

@AppScope
@Subcomponent(modules = ChatModule.class)
public interface ChatComponent {
    void inject(ChatPresenter chatPresenter);
}
