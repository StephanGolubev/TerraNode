package com.itn.terranode.domain.main.news_screen;

import androidx.paging.PagedList;

import com.itn.terranode.data.network.dtos.NewsItem;

import io.reactivex.Observable;

public interface NewsInteractor {

    Observable<PagedList<NewsItem>> getPagedNews();
}
