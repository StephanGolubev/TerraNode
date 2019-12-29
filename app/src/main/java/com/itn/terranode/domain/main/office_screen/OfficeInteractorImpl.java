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
    OfficeInteractorImpl(NetworkRepository networkRepository) {
        this.networkRepository = networkRepository;
    }

    @Override
    public Maybe<Response<Object>> getInformationAboutUser() {
        return networkRepository.getInformationAboutUser("Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczpcL1wvaXRuLmx0ZFwvYXBpXC92MVwvbG9naW4iLCJpYXQiOjE1Nzc2NTA4NTAsImV4cCI6MTU3NzY1NDQ1MCwibmJmIjoxNTc3NjUwODUwLCJqdGkiOiI5Y0VWbXM4WjhybHpuYllMIiwic3ViIjo2ODcyLCJwcnYiOiI4N2UwYWYxZWY5ZmQxNTgxMmZkZWM5NzE1M2ExNGUwYjA0NzU0NmFhIn0.qI5bjrrgIBkDtabjY0vZLDf2bDCNf32x8tIe7hwufqA")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
