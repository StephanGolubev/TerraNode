package com.itn.terranode.domain.main.support_screen;

import io.reactivex.Maybe;
import retrofit2.Response;

public interface SupportInteractor {

    Maybe<Response<Object>> getChats();

    Maybe<Response<Object>> getStructure();

    Maybe<Response<Object>> searchUsers(String searchTerm);
}
