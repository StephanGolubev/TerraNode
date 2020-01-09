package com.itn.terranode.domain.main.news_screen;

import androidx.paging.PagedList;
import androidx.paging.RxPagedListBuilder;

import com.itn.terranode.data.network.NetworkRepository;
import com.itn.terranode.data.network.dtos.NewsItem;
import com.itn.terranode.data.network.dtos.SuccessNewsResponse;
import com.itn.terranode.data.shared_prefs.PrefsHelper;
import com.itn.terranode.presentation.view.main.news_screen.NewsDataSource;
import com.itn.terranode.presentation.view.main.news_screen.NewsDataSourceFactory;

import javax.inject.Inject;

import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class NewsInteractorImpl implements NewsInteractor{

    private final NetworkRepository networkRepository;
    private final PrefsHelper prefsHelper;

    @Inject
    NewsInteractorImpl(NetworkRepository networkRepository, PrefsHelper prefsHelper) {
        this.networkRepository = networkRepository;
        this.prefsHelper = prefsHelper;
    }

    @Override
    public Maybe<Response<SuccessNewsResponse>> getNews() {
        String token = "Bearer " + prefsHelper.getToken();
        return networkRepository.getNews(token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<PagedList<NewsItem>> getPagedNews() {
        NewsDataSourceFactory newsDataSourceFactory = new NewsDataSourceFactory(networkRepository, prefsHelper);
        PagedList.Config config = new PagedList.Config.Builder()
                .setPageSize(12)
                .build();
        return new RxPagedListBuilder(newsDataSourceFactory, config)
                .buildObservable();
    }
}
