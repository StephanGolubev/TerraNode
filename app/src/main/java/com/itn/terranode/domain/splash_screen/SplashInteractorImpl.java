package com.itn.terranode.domain.splash_screen;

import com.itn.terranode.data.network.NetworkRepository;
import com.itn.terranode.data.shared_prefs.PrefsHelper;

import javax.inject.Inject;

import io.reactivex.Single;

public class SplashInteractorImpl implements SplashInteractor{

    private final NetworkRepository networkRepository;
    private final PrefsHelper prefsHelper;

    @Inject
    public SplashInteractorImpl(NetworkRepository networkRepository, PrefsHelper prefsHelper) {
        this.networkRepository = networkRepository;
        this.prefsHelper = prefsHelper;
    }

    @Override
    public Single<Boolean> checkIfUserLoggedIn() {
        return Single.fromCallable(() -> prefsHelper.getToken().isEmpty());
    }
}
