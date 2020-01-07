package com.itn.terranode.domain.broadcast;

import com.itn.terranode.data.network.NetworkRepository;
import com.itn.terranode.data.network.dtos.LoginDTO;
import com.itn.terranode.data.shared_prefs.PrefsHelper;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class ReceiverInteractorImpl implements ReceiverInteractor {

    private final NetworkRepository networkRepository;
    private final PrefsHelper prefsHelper;

    @Inject
    ReceiverInteractorImpl(NetworkRepository networkRepository, PrefsHelper prefsHelper) {
        this.networkRepository = networkRepository;
        this.prefsHelper = prefsHelper;
    }

    @Override
    public Maybe<Response<Object>> refreshToken() {
        String token = "Bearer " + prefsHelper.getToken();
        return networkRepository.refreshToken(token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Completable saveToken(String accessToken) {
        return Completable.fromCallable(() -> {
            prefsHelper.setToken(accessToken);
            return Completable.complete();
        });
    }

    @Override
    public void clearPrefs() {
        prefsHelper.clearPrefs();
    }
}
