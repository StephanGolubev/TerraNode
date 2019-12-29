package com.itn.terranode.domain.login.login_screen;

import com.itn.terranode.data.network.NetworkRepository;
import com.itn.terranode.data.network.dtos.LoginDTO;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class LoginInteractorImpl implements LoginInteractor {

    private final NetworkRepository networkRepository;

    @Inject
    public LoginInteractorImpl(NetworkRepository networkRepository) {
        this.networkRepository = networkRepository;
    }


    @Override
    public Maybe<Response<Object>> login(String email, String password) {
        return networkRepository.login(new LoginDTO(email, password))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Completable saveToken(String accessToken) {
        return Completable.complete();
    }
}
