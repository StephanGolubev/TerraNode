package com.itn.terranode.presentation.presenter.splash_screen;

import com.itn.terranode.presentation.view.splash_screen.SplashScreenView;

import moxy.InjectViewState;
import moxy.MvpPresenter;

@InjectViewState
public class SplashScreenPresenter extends MvpPresenter<SplashScreenView> {

    public void checkIsUserLoggedIn() {
        if(true){
            getViewState().showLoginScreen();
        }else {
            getViewState().showMainScreen();
        }
    }
}
