package com.itn.terranode.domain.login.login_screen;

import io.reactivex.Maybe;
import retrofit2.Response;

public interface LoginInteractor {

    Maybe<Response> login(String email, String password);
}
