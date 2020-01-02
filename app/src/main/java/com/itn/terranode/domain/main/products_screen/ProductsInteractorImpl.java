package com.itn.terranode.domain.main.products_screen;

import com.itn.terranode.data.network.NetworkRepository;
import com.itn.terranode.data.network.dtos.SuccessProductsResponse;
import com.itn.terranode.data.shared_prefs.PrefsHelper;

import javax.inject.Inject;

import io.reactivex.Maybe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class ProductsInteractorImpl implements ProductsInteractor {

    private final NetworkRepository networkRepository;
    private final PrefsHelper prefsHelper;

    @Inject
    ProductsInteractorImpl(NetworkRepository networkRepository, PrefsHelper prefsHelper) {
        this.networkRepository = networkRepository;
        this.prefsHelper = prefsHelper;
    }

    @Override
    public Maybe<SuccessProductsResponse> getProducts() {
        String token = "Bearer " + prefsHelper.getToken();
        return networkRepository.getProducts(token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
