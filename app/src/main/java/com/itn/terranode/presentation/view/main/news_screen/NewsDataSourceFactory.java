package com.itn.terranode.presentation.view.main.news_screen;

import androidx.annotation.NonNull;
import androidx.paging.DataSource;

import com.itn.terranode.data.network.NetworkRepository;
import com.itn.terranode.data.network.dtos.NewsItem;
import com.itn.terranode.data.shared_prefs.PrefsHelper;

public class NewsDataSourceFactory extends DataSource.Factory<Integer, NewsItem> {

    private final NetworkRepository networkRepository;
    private final PrefsHelper prefsHelper;

    public NewsDataSourceFactory(NetworkRepository networkRepository, PrefsHelper prefsHelper) {
        this.networkRepository = networkRepository;
        this.prefsHelper = prefsHelper;
    }

    @NonNull
    @Override
    public DataSource<Integer, NewsItem> create() {
        return new NewsDataSource(networkRepository, prefsHelper);
    }
}
