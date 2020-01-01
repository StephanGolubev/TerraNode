package com.itn.terranode.presentation.view.main.news_screen;

import moxy.MvpView;

public interface NewsView extends MvpView {
    void showNews(List<News> newsList);

    void showToast(String message);
}
