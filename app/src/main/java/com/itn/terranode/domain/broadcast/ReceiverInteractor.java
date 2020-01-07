package com.itn.terranode.domain.broadcast;

import io.reactivex.Completable;
import io.reactivex.Maybe;
import retrofit2.Response;

public interface ReceiverInteractor {
    Maybe<Response<Object>> refreshToken();

    Completable saveToken(String accessToken);

    void clearPrefs();
}
