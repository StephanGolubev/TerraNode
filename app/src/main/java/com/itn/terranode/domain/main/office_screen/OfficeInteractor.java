package com.itn.terranode.domain.main.office_screen;

import com.itn.terranode.data.network.dtos.SuccessLogoutResponse;
import com.itn.terranode.data.network.dtos.SuccessOfficeResponse;

import io.reactivex.Maybe;

public interface OfficeInteractor {

    Maybe<SuccessOfficeResponse> getInformationAboutUser();

    Maybe<SuccessLogoutResponse> logout();
}
