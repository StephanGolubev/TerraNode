package com.itn.terranode.domain.main.support_screen;

import androidx.paging.PagedList;
import androidx.paging.RxPagedListBuilder;

import com.itn.terranode.data.network.NetworkRepository;
import com.itn.terranode.data.network.dtos.SuccessChatsResponce;
import com.itn.terranode.data.network.dtos.SuccessSearchResponce;
import com.itn.terranode.data.network.dtos.User;
import com.itn.terranode.data.shared_prefs.PrefsHelper;
import com.itn.terranode.presentation.view.main.support_screen.StructureDataSourceFactory;

import javax.inject.Inject;

import io.reactivex.Maybe;
import io.reactivex.Observable;
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
    public Maybe<Response<SuccessChatsResponce>> getChats() {
        String token = "Bearer " + prefsHelper.getToken();
        return networkRepository.getChatsList(token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<PagedList<User>> getStructure() {
        StructureDataSourceFactory dataSourceFactory = new StructureDataSourceFactory(networkRepository, prefsHelper);
        PagedList.Config config = (new PagedList.Config.Builder())
                .build();
        return new RxPagedListBuilder(dataSourceFactory, config)
                .buildObservable();
    }

    @Override
    public Maybe<SuccessSearchResponce> searchUsers(String searchTerm) {
        String token = "Bearer " + prefsHelper.getToken();
        return networkRepository.searchUsers(token, searchTerm)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
