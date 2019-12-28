package com.itn.terranode.presentation.view.login.login_screen;

import moxy.MvpView;
import moxy.viewstate.strategy.AddToEndSingleStrategy;
import moxy.viewstate.strategy.StateStrategyType;

public interface LoginScreenView extends MvpView {

    @StateStrategyType(AddToEndSingleStrategy.class)
    void showToast(String message);
}
