package com.itn.terranode.presentation.view.main.news_screen;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import com.itn.terranode.data.network.NetworkRepository;
import com.itn.terranode.data.network.dtos.NewsItem;
import com.itn.terranode.data.shared_prefs.PrefsHelper;

import javax.inject.Inject;

public class NewsDataSource extends PageKeyedDataSource<Long, NewsItem> {

    @Inject
    NetworkRepository networkRepository;
    @Inject
    PrefsHelper prefsHelper;

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Long> params, @NonNull LoadInitialCallback<Long, NewsItem> callback) {
        String token = "Bearer " + prefsHelper.getToken();
        networkRepository.getPagedNews(token, 1);
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Long> params, @NonNull LoadCallback<Long, NewsItem> callback) {

    }

    @Override
    public void loadAfter(@NonNull LoadParams<Long> params, @NonNull LoadCallback<Long, NewsItem> callback) {

    }
}
