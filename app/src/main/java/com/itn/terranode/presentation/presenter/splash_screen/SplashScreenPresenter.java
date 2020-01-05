package com.itn.terranode.presentation.presenter.splash_screen;

import com.itn.terranode.di.app.App;
import com.itn.terranode.domain.login.login_screen.LoginInteractor;
import com.itn.terranode.domain.splash_screen.SplashInteractor;
import com.itn.terranode.presentation.view.splash_screen.SplashScreenView;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import moxy.InjectViewState;
import moxy.MvpPresenter;

@InjectViewState
public class SplashScreenPresenter extends MvpPresenter<SplashScreenView> {

    private final CompositeDisposable compositeDisposable;

    @Inject
    SplashInteractor interactor;

    public SplashScreenPresenter() {
        compositeDisposable = new CompositeDisposable();
        App.getInstance().plusSplashComponent().inject(this);
    }

    public void checkIsUserLoggedIn() {
        compositeDisposable.add(
                interactor
                        .checkIfUserLoggedIn()
                        .subscribe(aBoolean -> {
                                    if(aBoolean){
                                        getViewState().showLoginScreen();
                                    }else {
                                        getViewState().showMainScreen();
                                    }
                                },
                                throwable -> getViewState().showLoginScreen()));

    }
}
