package com.itn.terranode.di.main.news_screen;

import com.itn.terranode.di.scopes.AppScope;
import com.itn.terranode.domain.main.news_screen.NewsInteractor;
import com.itn.terranode.domain.main.news_screen.NewsInteractorImpl;

import dagger.Binds;
import dagger.Module;

@Module
public interface  NewsModule {

    @Binds
    @AppScope
    NewsInteractor provideNewsInteractor(NewsInteractorImpl interactor);
}
