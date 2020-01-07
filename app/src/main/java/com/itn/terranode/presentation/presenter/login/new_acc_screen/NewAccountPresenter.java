package com.itn.terranode.presentation.presenter.login.new_acc_screen;

import android.util.Log;

import com.google.gson.Gson;
import com.itn.terranode.data.network.dtos.DetailMessageErrorResponse;
import com.itn.terranode.data.network.dtos.NewAccountSuccessResponse;
import com.itn.terranode.di.app.App;
import com.itn.terranode.domain.login.new_acc_screen.NewAccountInteractor;
import com.itn.terranode.presentation.view.login.new_acc_screen.NewAccountView;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import moxy.InjectViewState;
import moxy.MvpPresenter;
import okhttp3.ResponseBody;
import retrofit2.Response;

@InjectViewState
public class NewAccountPresenter extends MvpPresenter<NewAccountView> {

    private final CompositeDisposable compositeDisposable;

    @Inject
    NewAccountInteractor interactor;

    public NewAccountPresenter() {
        compositeDisposable = new CompositeDisposable();
        App.getInstance().plusNewAccountComponent().inject(this);
    }

    public void createNewAccount(String fullname, String email, String password, String sponsor) {
        compositeDisposable.add(interactor.createNewAccount(fullname, email, password, sponsor)
                .subscribe(response -> {
                    switch (response.code()) {
                        case 400: {
                            ResponseBody responseBody = response.errorBody();
                            findErrors(responseBody.string());

//                                    DetailMessageErrorResponse errorResponse = new Gson().fromJson(responseBody.string(), DetailMessageErrorResponse.class);
                            break;
                        }
                        case 200: {
                            NewAccountSuccessResponse successResponse = (NewAccountSuccessResponse) response.body();
                            break;
                        }
                        default: {
                            NewAccountPresenter.this.showMessage(response.message());
                        }
                    }
                },
                        throwable -> showMessage(throwable.getMessage()),
                        () -> NewAccountPresenter.this.showMessage("Try to create account later"))
        );
    }

    private void findErrors(String string) {
        String nahcalnayaStroka = string.replaceAll("\"", "");

        String resultErrorString = "";

        String emailSubstring = "";
        String passwordSubstring = "";
        String sponsorId = "";

        if (nahcalnayaStroka.contains("email")) {
            int beginIndex = nahcalnayaStroka.indexOf("email");
            String substring = nahcalnayaStroka.substring(beginIndex);
            beginIndex = substring.indexOf("[");
            int lastIndex = substring.indexOf("]");
            emailSubstring = substring.substring(beginIndex + 1, lastIndex);
            resultErrorString = resultErrorString + emailSubstring + "\n";
        }

        if (nahcalnayaStroka.contains("password")) {
            int beginIndex = nahcalnayaStroka.indexOf("password");
            String substring = nahcalnayaStroka.substring(beginIndex);
            beginIndex = substring.indexOf("[");
            int lastIndex = substring.indexOf("]");
            passwordSubstring = substring.substring(beginIndex + 1, lastIndex);
            resultErrorString = resultErrorString + passwordSubstring + "\n";
        }

        if (nahcalnayaStroka.contains("password")) {
            int beginIndex = nahcalnayaStroka.indexOf("password");
            String substring = nahcalnayaStroka.substring(beginIndex);
            beginIndex = substring.indexOf("[");
            int lastIndex = substring.indexOf("]");
            passwordSubstring = substring.substring(beginIndex + 1, lastIndex);
            resultErrorString = resultErrorString + passwordSubstring + "\n";
        }

        if (nahcalnayaStroka.contains("sponsor_id")) {
            int beginIndex = nahcalnayaStroka.indexOf("sponsor_id");
            String substring = nahcalnayaStroka.substring(beginIndex);
            beginIndex = substring.indexOf("[");
            int lastIndex = substring.indexOf("]");
            sponsorId = substring.substring(beginIndex + 1, lastIndex);
            resultErrorString = resultErrorString + sponsorId + "\n";
        }

        if (nahcalnayaStroka.contains("sponsor_id")) {
            int beginIndex = nahcalnayaStroka.indexOf("sponsor_id");
            String substring = nahcalnayaStroka.substring(beginIndex);
            beginIndex = substring.indexOf("[");
            int lastIndex = substring.indexOf("]");
            sponsorId = substring.substring(beginIndex + 1, lastIndex);
            resultErrorString = resultErrorString + sponsorId + "\n";
        }
        showMessage(resultErrorString);
    }

    private void showMessage(String message) {
        getViewState().showToast(message);
    }

    public void destroy() {
        compositeDisposable.clear();
        App.getInstance().clearNewAccountComponent();
    }
}
