package com.itn.terranode.domain.main.news_screen;

import androidx.paging.PagedList;
import androidx.paging.RxPagedListBuilder;

import com.itn.terranode.data.network.NetworkRepository;
import com.itn.terranode.data.network.dtos.NewsItem;
import com.itn.terranode.data.shared_prefs.PrefsHelper;
import com.itn.terranode.presentation.view.main.news_screen.NewsDataSourceFactory;

import javax.inject.Inject;

import io.reactivex.Observable;

public class NewsInteractorImpl implements NewsInteractor{

    private final NetworkRepository networkRepository;
    private final PrefsHelper prefsHelper;

    @Inject
    NewsInteractorImpl(NetworkRepository networkRepository, PrefsHelper prefsHelper) {
        this.networkRepository = networkRepository;
        this.prefsHelper = prefsHelper;
    }

    @Override
    public Observable<PagedList<NewsItem>> getPagedNews() {
        NewsDataSourceFactory newsDataSourceFactory = new NewsDataSourceFactory(networkRepository, prefsHelper);
        PagedList.Config config = (new PagedList.Config.Builder())
//                .setEnablePlaceholders(false)
//                .setPageSize(12)
                .build();
        return new RxPagedListBuilder(newsDataSourceFactory, config)
                .buildObservable();
    }
}
