package com.itn.terranode.domain.login.new_acc_screen;

import com.itn.terranode.data.network.NetworkRepository;
import com.itn.terranode.data.network.dtos.NewAccountDTO;

import javax.inject.Inject;

import io.reactivex.Maybe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class NewAccountInteractorImpl implements NewAccountInteractor {

    private final NetworkRepository networkRepository;

    @Inject
    public NewAccountInteractorImpl(NetworkRepository networkRepository) {
        this.networkRepository = networkRepository;
    }


    @Override
    public Maybe<Response<Object>> createNewAccount(String fullname, String email, String password, String sponsor) {
        return networkRepository.createNewAccount(new NewAccountDTO(fullname, email, password, sponsor))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
