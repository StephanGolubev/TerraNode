package com.itn.terranode.presentation.view.main.office_screen;

import com.itn.terranode.data.network.dtos.InformationAboutUser;

import moxy.MvpView;
import moxy.viewstate.strategy.AddToEndSingleStrategy;
import moxy.viewstate.strategy.StateStrategyType;

public interface OfficeView extends MvpView {
    @StateStrategyType(AddToEndSingleStrategy.class)
    void showInformation(InformationAboutUser informationAboutUser);
    @StateStrategyType(AddToEndSingleStrategy.class)
    void showToast(String message);
}
