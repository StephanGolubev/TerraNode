package com.itn.terranode.domain.main.news_screen;

import com.itn.terranode.data.network.dtos.SuccessNewsResponse;

import io.reactivex.Maybe;

public interface NewsInteractor {
    Maybe<SuccessNewsResponse> getNews();
}
