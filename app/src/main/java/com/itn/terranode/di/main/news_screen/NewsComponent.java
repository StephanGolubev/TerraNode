package com.itn.terranode.di.main.news_screen;

import com.itn.terranode.di.scopes.AppScope;
import com.itn.terranode.presentation.presenter.main.news_screen.NewsPresenter;

import dagger.Subcomponent;

@AppScope
@Subcomponent(modules = NewsModule.class)
public interface NewsComponent {
    void inject(NewsPresenter newsPresenter);
}
