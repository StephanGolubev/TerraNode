package com.itn.terranode.domain.main.office_screen;

import com.google.gson.Gson;
import com.itn.terranode.data.network.NetworkRepository;
import com.itn.terranode.data.network.dtos.DetailMessageErrorResponse;
import com.itn.terranode.data.network.dtos.SuccessLogoutResponse;
import com.itn.terranode.data.network.dtos.SuccessOfficeResponse;
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
    public Maybe<Response<SuccessOfficeResponse>> getInformationAboutUser() {
        String token = "Bearer " + prefsHelper.getToken();
        return networkRepository
                .getInformationAboutUser(token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

    }

    @Override
    public Maybe<SuccessLogoutResponse> logout() {
        String token = "Bearer " + prefsHelper.getToken();
        return networkRepository.logout(token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public void saveCurrentId(String id) {
        prefsHelper.setCurrentId(id);
    }

    @Override
    public void clearAll() {
        prefsHelper.clearPrefs();
    }

}
