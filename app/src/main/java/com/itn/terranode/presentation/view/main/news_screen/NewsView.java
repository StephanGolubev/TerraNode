package com.itn.terranode.presentation.view.main.news_screen;

import com.itn.terranode.data.network.dtos.NewsItem;

import java.util.List;

import moxy.MvpView;
import moxy.viewstate.strategy.AddToEndSingleStrategy;
import moxy.viewstate.strategy.StateStrategyType;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface NewsView extends MvpView {
    void showNews(List<NewsItem> newsItems);

    void showToast(String message);
}
