package com.itn.terranode.presentation.presenter.login.login_screen;

import com.itn.terranode.di.app.App;
import com.itn.terranode.domain.login.login_screen.LoginInteractor;
import com.itn.terranode.presentation.view.login.login_screen.LoginScreenView;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import moxy.InjectViewState;
import moxy.MvpPresenter;

@InjectViewState
public class LoginPresenter extends MvpPresenter<LoginScreenView> {

    private final CompositeDisposable compositeDisposable;

    @Inject
    LoginInteractor interactor;

    public LoginPresenter() {
        compositeDisposable = new CompositeDisposable();
        App.getInstance().plusLoginComponent().inject(this);
    }

    public void login(String email, String password){
        compositeDisposable.add(
                interactor
                        .login(email, password)
                        .subscribe(loginResponse -> {
                                    loginResponse.isSuccessful();
                                },
                                throwable -> {
                                    showMessage(throwable.getMessage());
                                },
                                () -> {
                                    showMessage("Try to login later");
                                }
                        )
        );
    }

    private void showMessage(String message) {
        getViewState().showToast(message);
    }

    public void destroy() {
        compositeDisposable.clear();
        App.getInstance().clearLoginComponent();
    }
}
