package com.itn.terranode.domain.main.news_screen;

import com.itn.terranode.data.network.dtos.SuccessNewsResponse;

import io.reactivex.Maybe;
import io.reactivex.Observable;
import retrofit2.Response;

public interface NewsInteractor {
    Maybe<Response<SuccessNewsResponse>> getNews();

    Observable getPagedNews();
}
