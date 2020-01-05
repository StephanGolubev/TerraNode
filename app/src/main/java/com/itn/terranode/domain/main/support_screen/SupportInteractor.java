package com.itn.terranode.domain.main.support_screen;

import com.itn.terranode.data.network.dtos.SuccessChatsResponce;
import com.itn.terranode.data.network.dtos.SuccessSearchResponce;
import com.itn.terranode.data.network.dtos.SuccessStructureResponce;

import io.reactivex.Maybe;
import retrofit2.Response;

public interface SupportInteractor {

    Maybe<Response<SuccessChatsResponce>> getChats();

    Maybe<Response<SuccessStructureResponce>> getStructure();

    Maybe<SuccessSearchResponce> searchUsers(String searchTerm);
}
