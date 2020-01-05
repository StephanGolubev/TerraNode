package com.itn.terranode.domain.main.news_screen;

import com.itn.terranode.data.network.dtos.SuccessNewsResponse;

import io.reactivex.Maybe;
import retrofit2.Response;

public interface NewsInteractor {
    Maybe<Response<SuccessNewsResponse>> getNews();
}
