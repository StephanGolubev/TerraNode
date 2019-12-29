package com.itn.terranode.domain.login.login_screen;

import com.itn.terranode.di.login.login_screen.LoginModule;
import com.itn.terranode.di.scopes.AppScope;

import dagger.Subcomponent;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import retrofit2.Response;
@AppScope
@Subcomponent(modules = LoginModule.class)
public interface LoginInteractor {

    Maybe<Response<Object>> login(String email, String password);

    Completable saveToken(String accessToken);
}
