package com.itn.terranode.domain.main.office_screen;

import com.itn.terranode.data.network.dtos.SuccessLogoutResponse;
import com.itn.terranode.data.network.dtos.SuccessOfficeResponse;

import io.reactivex.Maybe;
import io.reactivex.disposables.Disposable;
import retrofit2.Response;

public interface OfficeInteractor {

    Maybe<Response<SuccessOfficeResponse>>  getInformationAboutUser();

    Maybe<SuccessLogoutResponse> logout();

    void saveCurrentId(String id);

    void clearAll();
}
