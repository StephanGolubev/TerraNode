package com.itn.terranode.presentation.presenter.main.news_screen;

import com.google.gson.Gson;
import com.itn.terranode.data.network.dtos.DetailMessageErrorResponse;
import com.itn.terranode.data.network.dtos.SuccessNewsResponse;
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
                interactor
                        .getNews()
                        .doOnSubscribe(disposable -> getViewState().showProgressBar())
                        .doAfterTerminate(() -> getViewState().hideProgressBar())
                        .subscribe(response -> {
                            switch (response.getStatus()){
                                case "400":{
        //                            ResponseBody responseBody = response.errorBody();
        //                            DetailMessageErrorResponse errorResponse = new Gson().fromJson(responseBody.string(), DetailMessageErrorResponse.class);
                                    break;
                                }
                                case "200":{
                                    getViewState().showNews(response.getData().getNewsItems());
                                    break;
                                }
                                default:{
                                    //showMessage(response.message());
                                }
                            }
                        },
                        throwable -> showMessage(throwable.getMessage()),
                        () -> showMessage("Try to login later")
        ));
    }

    private void showMessage(String message) {
        getViewState().showToast(message);
    }
}
