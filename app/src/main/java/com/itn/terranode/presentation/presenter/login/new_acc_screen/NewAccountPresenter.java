package com.itn.terranode.presentation.presenter.login.new_acc_screen;

import com.itn.terranode.di.app.App;
import com.itn.terranode.domain.login.new_acc_screen.NewAccountInteractor;
import com.itn.terranode.presentation.view.login.new_acc_screen.NewAccountView;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import moxy.InjectViewState;
import moxy.MvpPresenter;
import okhttp3.ResponseBody;

@InjectViewState
public class NewAccountPresenter extends MvpPresenter<NewAccountView> {

    private final CompositeDisposable compositeDisposable;

    @Inject
    NewAccountInteractor interactor;

    public NewAccountPresenter() {
        compositeDisposable = new CompositeDisposable();
        App.getInstance().plusNewAccountComponent().inject(this);
    }

    public void createNewAccount(String fullname, String email, String password, String sponsor) {
        compositeDisposable.add(interactor.createNewAccount(fullname, email, password, sponsor)
                .subscribe(response -> {
                            switch (response.code()){
                                case 400:{
                                    ResponseBody responseBody = response.errorBody();
                                    break;
                                }
                                case 200:{
                                    break;
                                }
                                default:{

                                }
                            }
                        },
                        throwable -> {
                            showMessage(throwable.getMessage());
                        },
                        () -> {
                            showMessage("Try to create account later");
                        })
        );
    }

    private void showMessage(String message) {
        getViewState().showToast(message);
    }
}
