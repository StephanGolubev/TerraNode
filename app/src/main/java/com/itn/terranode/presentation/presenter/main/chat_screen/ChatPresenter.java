package com.itn.terranode.presentation.presenter.main.chat_screen;

import com.itn.terranode.data.network.dtos.SuccessGetMessageFromChatResponce;
import com.itn.terranode.di.app.App;
import com.itn.terranode.domain.main.chat_screen.ChatInteractor;
import com.itn.terranode.presentation.view.main.chat_screen.ChatView;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import moxy.InjectViewState;
import moxy.MvpPresenter;

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

    private void showResult(SuccessGetMessageFromChatResponce response) {
        switch (response.getStatus()){
            case "400":{
                //                            ResponseBody responseBody = response.errorBody();
                //                            DetailMessageErrorResponse errorResponse = new Gson().fromJson(responseBody.string(), DetailMessageErrorResponse.class);
                break;
            }
            case "200":{
                String s = interactor.getCurrentId();
                getViewState().showChat(response.getData().getChatMessages(), s);

                break;
            }
            default:{
//                showMessage(response.message());
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
