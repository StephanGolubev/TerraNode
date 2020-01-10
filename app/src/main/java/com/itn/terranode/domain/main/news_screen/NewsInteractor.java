package com.itn.terranode.domain.main.news_screen;

import androidx.paging.PagedList;

import com.itn.terranode.data.network.dtos.NewsItem;
import com.itn.terranode.data.network.dtos.SuccessNewsResponse;

import io.reactivex.Maybe;
import io.reactivex.Observable;
import retrofit2.Response;

public interface NewsInteractor {

    Observable<PagedList<NewsItem>> getPagedNews();
}
