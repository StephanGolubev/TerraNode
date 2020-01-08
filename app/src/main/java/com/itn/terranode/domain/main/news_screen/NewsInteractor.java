package com.itn.terranode.domain.main.news_screen;

import androidx.paging.PagedList;

import com.itn.terranode.data.network.dtos.NewsItem;
import com.itn.terranode.data.network.dtos.SuccessNewsResponse;

import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import retrofit2.Response;

public interface NewsInteractor {
    Maybe<Response<SuccessNewsResponse>> getNews();

    Observable<PagedList<NewsItem>> getPagedNews();
}
