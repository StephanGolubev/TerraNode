package com.itn.terranode.presentation.view.splash_screen;

import moxy.MvpView;
import moxy.viewstate.strategy.AddToEndSingleStrategy;
import moxy.viewstate.strategy.StateStrategyType;

public interface SplashScreenView extends MvpView {
    @StateStrategyType(AddToEndSingleStrategy.class)
    void showMainScreen();

    @StateStrategyType(AddToEndSingleStrategy.class)
    void showLoginScreen();
}
