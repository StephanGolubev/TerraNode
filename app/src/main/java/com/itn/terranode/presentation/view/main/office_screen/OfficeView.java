package com.itn.terranode.presentation.view.main.office_screen;

import com.itn.terranode.data.network.dtos.InformationAboutUser;

import moxy.MvpView;
import moxy.viewstate.strategy.AddToEndSingleStrategy;
import moxy.viewstate.strategy.StateStrategyType;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface OfficeView extends MvpView {

    void showInformation(InformationAboutUser informationAboutUser);

    void showToast(String message);

    void showProgressBar();

    void hideProgressBar();

    void quit();
}
