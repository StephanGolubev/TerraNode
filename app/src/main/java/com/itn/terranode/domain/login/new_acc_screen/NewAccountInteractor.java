package com.itn.terranode.domain.login.new_acc_screen;

import io.reactivex.Maybe;
import retrofit2.Response;

public interface NewAccountInteractor {

    Maybe<Response<Object>> createNewAccount(String fullname, String email, String password, String sponsor);
}
