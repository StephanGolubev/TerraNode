package com.itn.terranode.data.network;

import com.itn.terranode.data.network.dtos.LoginDTO;
import com.itn.terranode.data.network.dtos.NewAccountDTO;

import io.reactivex.Maybe;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface NetworkRepository {

    @POST("/api/v1/register")
    Maybe<Response<Object>> createNewAccount(@Body NewAccountDTO gatewayAuthorizeRequest);

    @POST("/api/v1/login")
    Maybe<Response<Object>> login(@Body LoginDTO gatewayAuthorizeRequest);

//    @POST("/api/v1/logout")
//    @Headers("content-type: application/json")
//    Maybe<Response<Object>> login(@Header("Authorization") String authorization, @Body LoginDTO gatewayAuthorizeRequest);


}
