package com.itn.terranode.domain.main.support_screen;

import com.itn.terranode.data.network.NetworkRepository;
import com.itn.terranode.data.network.dtos.SuccessChatsResponce;
import com.itn.terranode.data.network.dtos.SuccessSearchResponce;
import com.itn.terranode.data.network.dtos.SuccessStructureResponce;
import com.itn.terranode.data.shared_prefs.PrefsHelper;

import javax.inject.Inject;

import io.reactivex.Maybe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class SupportInteractorImpl implements SupportInteractor {

    private final NetworkRepository networkRepository;
    private final PrefsHelper prefsHelper;

    @Inject
    SupportInteractorImpl(NetworkRepository networkRepository, PrefsHelper prefsHelper) {
        this.networkRepository = networkRepository;
        this.prefsHelper = prefsHelper;
    }
    @Override
    public Maybe<SuccessChatsResponce> getChats() {
        String token = "Bearer " + prefsHelper.getToken();
        return networkRepository.getChatsList(token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Maybe<SuccessStructureResponce> getStructure() {
        String token = "Bearer " + prefsHelper.getToken();
        return networkRepository.getStructure(token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Maybe<SuccessSearchResponce> searchUsers(String searchTerm) {
        String token = "Bearer " + prefsHelper.getToken();
        return networkRepository.searchUsers(token, searchTerm)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
