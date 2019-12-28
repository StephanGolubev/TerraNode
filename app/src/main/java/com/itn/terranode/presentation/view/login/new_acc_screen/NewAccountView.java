package com.itn.terranode.presentation.view.login.new_acc_screen;

import moxy.MvpView;
import moxy.viewstate.strategy.AddToEndSingleStrategy;
import moxy.viewstate.strategy.StateStrategyType;

public interface NewAccountView extends MvpView {

    @StateStrategyType(AddToEndSingleStrategy.class)
    void showToast(String message);
}
