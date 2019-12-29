package com.itn.terranode.domain.main.office_screen;

import io.reactivex.Maybe;
import retrofit2.Response;

public interface OfficeInteractor {

    Maybe<Response<Object>> getInformationAboutUser(String token);
}
