package com.itn.terranode.presentation.presenter.main.chat_screen;

import com.google.gson.Gson;
import com.itn.terranode.data.network.dtos.DetailMessageErrorResponse;
import com.itn.terranode.data.network.dtos.SuccessGetMessageFromChatResponce;
import com.itn.terranode.di.app.App;
import com.itn.terranode.domain.main.chat_screen.ChatInteractor;
import com.itn.terranode.presentation.view.main.chat_screen.ChatView;

import java.io.IOException;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import moxy.InjectViewState;
import moxy.MvpPresenter;
import okhttp3.ResponseBody;
import retrofit2.Response;

@InjectViewState
public class ChatPresenter extends MvpPresenter<ChatView> {

    private final CompositeDisposable compositeDisposable;

    @Inject
    ChatInteractor interactor;

    public ChatPresenter() {
        App.getInstance().plusChatComponent().inject(this);
        compositeDisposable = new CompositeDisposable();
    }

    public void createChat(String userId) {
        compositeDisposable.add(
                interactor
                        .createChat(userId)
                        .doOnSubscribe(disposable -> getViewState().showProgressBar())
                        .doAfterTerminate(() -> getViewState().hideProgressBar())
                        .subscribe(
                                this::showResult,
                                throwable -> showMessage(throwable.getMessage()),
                                () -> {

                                }
                                )
        );
    }


    public void getMessages(String chatId) {
        compositeDisposable.add(
                interactor
                        .getMessages(chatId)
                        .doOnSubscribe(disposable -> getViewState().showProgressBar())
                        .doAfterTerminate(() -> getViewState().hideProgressBar())
                        .subscribe(
                                this::showResult,
                                throwable -> showMessage(throwable.getMessage()),
                                () -> {

                                }
                        )
        );
    }

    public void sendMessage(String message) {
        compositeDisposable.add(interactor.sendMessage(message)
                .doOnSubscribe(disposable -> getViewState().showProgressBar())
                .doAfterTerminate(() -> getViewState().hideProgressBar())
                .subscribe(
                        response -> {
                            switch (response.code()) {
                                case 400: {
                                    ResponseBody responseBody = response.errorBody();
                                    DetailMessageErrorResponse errorResponse = new Gson().fromJson(responseBody.string(), DetailMessageErrorResponse.class);
                                    showMessage(errorResponse.getError().getMessage());
                                    break;
                                }
                                case 200: {
                                    getViewState().clearEditText();
                                    break;
                                }
                                default: {
                                    showMessage("Unexpected Error");
                                }
                            }

                        },
                        throwable -> showMessage(throwable.getMessage()),
                        () -> showMessage("Unexpected Error")
                        )
        );
    }

    private void showResult(Response<SuccessGetMessageFromChatResponce> response) throws IOException {
        switch (response.code()) {
            case 400: {
                ResponseBody responseBody = response.errorBody();
                DetailMessageErrorResponse errorResponse = new Gson().fromJson(responseBody.string(), DetailMessageErrorResponse.class);
                showMessage(errorResponse.getError().getMessage());
                break;
            }
            case 200: {
                getViewState().showChat(response.body().getData().getChatMessages(), interactor.getCurrentId());
                break;
            }
            default: {
                showMessage("Unexpected Error");
            }
        }
    }

    private void showMessage(String message) {
        getViewState().showToast(message);
    }

    public void destroy() {
        compositeDisposable.clear();
        App.getInstance().clearChatComponent();
    }
}
