package com.itn.terranode.presentation.view.main.news_screen;

import com.itn.terranode.data.network.dtos.InformationAboutUser;

import moxy.MvpView;

public interface NewsView extends MvpView {
    void showNews(InformationAboutUser news);

    void showToast(String message);
}
