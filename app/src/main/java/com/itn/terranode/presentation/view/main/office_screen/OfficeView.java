package com.itn.terranode.presentation.view.main.office_screen;

import com.itn.terranode.data.network.dtos.InformationAboutUser;

import moxy.MvpView;

public interface OfficeView extends MvpView {

    void showInformation(InformationAboutUser informationAboutUser);
}
