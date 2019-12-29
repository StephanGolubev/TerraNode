package com.itn.terranode.domain.main.office_screen;

import com.itn.terranode.data.network.NetworkRepository;

import javax.inject.Inject;

import io.reactivex.Maybe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class OfficeInteractorImpl implements OfficeInteractor {

    private final NetworkRepository networkRepository;

    @Inject
    public OfficeInteractorImpl(NetworkRepository networkRepository) {
        this.networkRepository = networkRepository;
    }

    @Override
    public Maybe<Response<Object>> getInformationAboutUser(String token) {
        return networkRepository.getInformationAboutUser("Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczpcL1wvaXRuLmx0ZFwvYXBpXC92MVwvbG9naW4iLCJpYXQiOjE1Nzc2MzU4ODMsImV4cCI6MTU3NzYzOTQ4MywibmJmIjoxNTc3NjM1ODgzLCJqdGkiOiJkSUtsbDhQa0Qzc0VSUVk5Iiwic3ViIjo2ODcyLCJwcnYiOiI4N2UwYWYxZWY5ZmQxNTgxMmZkZWM5NzE1M2ExNGUwYjA0NzU0NmFhIn0.JdLOZ5Jj6H7sMgRZMZLT7W8VRWanDZZAL3AGSIlK7tw")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
