package com.itn.terranode.presentation.presenter.main.news_screen;

import androidx.paging.PagedList;

import com.google.gson.Gson;
import com.itn.terranode.data.network.dtos.DetailMessageErrorResponse;
import com.itn.terranode.data.network.dtos.NewsItem;
import com.itn.terranode.di.app.App;
import com.itn.terranode.domain.main.news_screen.NewsInteractor;
import com.itn.terranode.presentation.view.main.news_screen.NewsView;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import moxy.InjectViewState;
import moxy.MvpPresenter;
import okhttp3.ResponseBody;

@InjectViewState
public class NewsPresenter extends MvpPresenter<NewsView> {

    private final CompositeDisposable compositeDisposable;

    @Inject
    NewsInteractor interactor;

    public NewsPresenter() {
        App.getInstance().plusNewsComponent().inject(this);
        compositeDisposable = new CompositeDisposable();
    }

    public void getNews() {
        compositeDisposable.add(
                interactor.getPagedNews().subscribe(newsItems -> getViewState().showNews(newsItems), throwable -> showMessage(throwable.getMessage()))
        );
    }

    private void showMessage(String message) {
        getViewState().showToast(message);
    }

    public void destroy() {
        compositeDisposable.clear();
        App.getInstance().clearNewsComponent();
    }
}
