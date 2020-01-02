package com.itn.terranode.domain.main.office_screen;

import com.itn.terranode.data.network.NetworkRepository;
import com.itn.terranode.data.shared_prefs.PrefsHelper;

import javax.inject.Inject;

import io.reactivex.Maybe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class OfficeInteractorImpl implements OfficeInteractor {

    private final NetworkRepository networkRepository;
    private final PrefsHelper prefsHelper;

    @Inject
    OfficeInteractorImpl(NetworkRepository networkRepository, PrefsHelper prefsHelper) {
        this.networkRepository = networkRepository;
        this.prefsHelper = prefsHelper;
    }

    @Override
    public Maybe<Response<Object>> getInformationAboutUser() {
        String token = "Bearer " + prefsHelper.getToken();
        return networkRepository.getInformationAboutUser(token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
