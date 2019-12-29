package com.itn.terranode.domain.login.login_screen;

import io.reactivex.Completable;
import io.reactivex.Maybe;
import retrofit2.Response;

public interface LoginInteractor {

    Maybe<Response<Object>> login(String email, String password);

    Completable saveToken(String accessToken);
}
