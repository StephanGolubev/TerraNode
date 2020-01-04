package com.itn.terranode.di.main.chat_screen;

import com.itn.terranode.di.scopes.AppScope;
import com.itn.terranode.domain.main.chat_screen.ChatInteractor;
import com.itn.terranode.domain.main.chat_screen.ChatInteractorImpl;

import dagger.Binds;
import dagger.Module;

@Module
public interface ChatModule {

    @Binds
    @AppScope
    ChatInteractor provideChatInteractor(ChatInteractorImpl interactor);
}
