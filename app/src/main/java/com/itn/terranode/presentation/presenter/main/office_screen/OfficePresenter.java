package com.itn.terranode.presentation.presenter.main.office_screen;

import com.google.gson.Gson;
import com.itn.terranode.data.network.dtos.DetailMessageErrorResponse;
import com.itn.terranode.data.network.dtos.OfficeSuccessResponse;
import com.itn.terranode.di.app.App;
import com.itn.terranode.domain.main.office_screen.OfficeInteractor;
import com.itn.terranode.presentation.view.main.office_screen.OfficeView;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import moxy.InjectViewState;
import moxy.MvpPresenter;
import okhttp3.ResponseBody;

@InjectViewState
public class OfficePresenter extends MvpPresenter<OfficeView> {

    private final CompositeDisposable compositeDisposable;

    @Inject
    OfficeInteractor interactor;

    public OfficePresenter() {
        this.compositeDisposable = new CompositeDisposable();
        App.getInstance().plusOfficeComponent().inject(this);
    }

    public void getInformationAboutUser() {
        compositeDisposable.add(interactor.getInformationAboutUser().subscribe(response -> {
                    switch (response.code()){
                        case 400:{
                            ResponseBody responseBody = response.errorBody();
                            DetailMessageErrorResponse errorResponse = new Gson().fromJson(responseBody.string(), DetailMessageErrorResponse.class);
                            break;
                        }
                        case 200:{
                            OfficeSuccessResponse successResponse = new Gson().fromJson(response.body().toString(), OfficeSuccessResponse.class);
                            getViewState().showInformation(successResponse.getData());
                            break;
                        }
                        default:{
                            showMessage(response.message());
                        }
                    }
                },
                throwable -> {
                    showMessage(throwable.getMessage());
                },
                () -> {
                    showMessage("Try to login later");
                }
        ));
    }

    public void clearAll() {

    }

    private void showMessage(String message) {
        getViewState().showToast(message);
    }
}
