package com.itn.terranode.domain.main.news_screen;

import io.reactivex.Maybe;
import retrofit2.Response;

public interface NewsInteractor {
    Maybe<Response<Object>> getNews();
}
