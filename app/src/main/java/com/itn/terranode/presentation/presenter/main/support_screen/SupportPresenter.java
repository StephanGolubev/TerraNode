package com.itn.terranode.presentation.presenter.main.support_screen;

import com.google.gson.Gson;
import com.itn.terranode.data.network.dtos.DetailMessageErrorResponse;
import com.itn.terranode.di.app.App;
import com.itn.terranode.domain.main.support_screen.SupportInteractor;
import com.itn.terranode.presentation.view.main.support_screen.SupportView;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import moxy.InjectViewState;
import moxy.MvpPresenter;
import okhttp3.ResponseBody;

@InjectViewState
public class SupportPresenter extends MvpPresenter<SupportView> {

    private final CompositeDisposable compositeDisposable;

    @Inject
    SupportInteractor interactor;

    public SupportPresenter() {
        App.getInstance().plusSupportComponent().inject(this);
        compositeDisposable = new CompositeDisposable();
    }

    public void search(String searchParam) {
        compositeDisposable.add(
                interactor
                        .searchUsers(searchParam)
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
                                        getViewState().showSearchResult(response.getData());
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

    public void getChats() {
        compositeDisposable.add(
                interactor
                        .getChats()
                        .doOnSubscribe(disposable -> getViewState().showProgressBar())
                        .doAfterTerminate(() -> getViewState().hideProgressBar())
                        .subscribe(response -> {
                                    switch (response.code()){
                                        case 400:{
                                            ResponseBody responseBody = response.errorBody();
                                            DetailMessageErrorResponse errorResponse = new Gson().fromJson(responseBody.string(), DetailMessageErrorResponse.class);
                                            showMessage(errorResponse.getError().getMessage());
                                            break;
                                        }
                                        case 200:{
                                            getViewState().showChats(response.body().getData());
                                            break;
                                        }
                                        default:{
                                            showMessage("Unexpected Error");
                                        }
                                    }
                                },
                                throwable -> showMessage(throwable.getMessage()),
                                () -> showMessage("Server timeout")
                        ));
    }

    public void getStructure() {
        compositeDisposable.add(
                interactor
                        .getStructure()
                        .doOnSubscribe(disposable -> getViewState().showProgressBar())
                        .doAfterTerminate(() -> getViewState().hideProgressBar())
                        .subscribe(response -> {
                                    switch (response.code()){
                                        case 400:{
                                            ResponseBody responseBody = response.errorBody();
                                            DetailMessageErrorResponse errorResponse = new Gson().fromJson(responseBody.string(), DetailMessageErrorResponse.class);
                                            showMessage(errorResponse.getError().getMessage());
                                            break;
                                        }
                                        case 200:{
                                            getViewState().showStructure(response.body().getData().getUsers());
                                            break;
                                        }
                                        default:{
                                            showMessage("Unexpected Error");
                                        }
                                    }
                                },
                                throwable -> showMessage(throwable.getMessage()),
                                () -> showMessage("Server timeout")
                        ));
    }

    private void showMessage(String message) {
        getViewState().showToast(message);
    }

    public void destroy() {
        compositeDisposable.clear();
        App.getInstance().clearSupportComponent();
    }
}
