package com.itn.terranode.domain.main.support_screen;

import androidx.paging.PagedList;

import com.itn.terranode.data.network.dtos.SuccessChatsResponce;
import com.itn.terranode.data.network.dtos.SuccessSearchResponce;
import com.itn.terranode.data.network.dtos.SuccessStructureResponce;
import com.itn.terranode.data.network.dtos.User;

import io.reactivex.Maybe;
import io.reactivex.Observable;
import retrofit2.Response;

public interface SupportInteractor {

    Maybe<Response<SuccessChatsResponce>> getChats();

    Observable<PagedList<User>> getStructure();

    Maybe<SuccessSearchResponce> searchUsers(String searchTerm);
}
