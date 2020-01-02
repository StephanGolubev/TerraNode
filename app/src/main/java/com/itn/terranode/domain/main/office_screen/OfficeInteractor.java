package com.itn.terranode.domain.main.office_screen;

import com.itn.terranode.data.network.dtos.SuccessOfficeResponse;

import io.reactivex.Maybe;
import retrofit2.Response;

public interface OfficeInteractor {

    Maybe<SuccessOfficeResponse> getInformationAboutUser();
}
