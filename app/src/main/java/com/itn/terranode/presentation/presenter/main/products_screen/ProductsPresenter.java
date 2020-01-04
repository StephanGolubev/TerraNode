package com.itn.terranode.presentation.presenter.main.products_screen;

import com.google.gson.Gson;
import com.itn.terranode.data.network.dtos.DetailMessageErrorResponse;
import com.itn.terranode.data.network.dtos.SuccessOfficeResponse;
import com.itn.terranode.di.app.App;
import com.itn.terranode.domain.main.products_screen.ProductsInteractor;
import com.itn.terranode.presentation.view.main.products_screen.ProductsView;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import moxy.InjectViewState;
import moxy.MvpPresenter;
import okhttp3.ResponseBody;

@InjectViewState
public class ProductsPresenter extends MvpPresenter<ProductsView> {

    private final CompositeDisposable compositeDisposable;

    @Inject
    ProductsInteractor interactor;

    public ProductsPresenter() {
        App.getInstance().plusProductsComponent().inject(this);
        compositeDisposable = new CompositeDisposable();
    }

    public void getProducts() {
        compositeDisposable.add(
                interactor
                        .getProducts()
                        .doOnSubscribe(disposable -> getViewState().showProgressBar())
                        .doAfterTerminate(() -> getViewState().hideProgressBar())
                        .subscribe(response -> {
                    switch (response.getStatus()) {
                        case "400": {
                            //ResponseBody responseBody = response.errorBody();
                           // DetailMessageErrorResponse errorResponse = new Gson().fromJson(responseBody.string(), DetailMessageErrorResponse.class);
                            break;
                        }
                        case "200": {
                            getViewState().showProducts(response.getData());
                            break;
                        }
                        default: {
                            //showMessage(response.message());
                        }
                    }
                },
                throwable -> showMessage(throwable.getMessage()),
                () -> showMessage("Try to login later")
        ));
    }

    private void showMessage(String message) {
        getViewState().showToast(message);
    }

    public void destroy() {
        compositeDisposable.clear();
        App.getInstance().clearProductsComponent();
    }
}
