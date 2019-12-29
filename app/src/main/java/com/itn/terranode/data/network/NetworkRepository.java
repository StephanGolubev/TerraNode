package com.itn.terranode.data.network;

import com.itn.terranode.data.network.dtos.LoginDTO;
import com.itn.terranode.data.network.dtos.NewAccountDTO;

import io.reactivex.Maybe;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface NetworkRepository {

    @POST("/api/v1/register")
    Maybe<Response<Object>> createNewAccount(@Body NewAccountDTO gatewayAuthorizeRequest);

    @POST("/api/v1/login")
    Maybe<Response<Object>> login(@Body LoginDTO gatewayAuthorizeRequest);

    @GET("/api/v1/user")
    @Headers("Accept: application/json")
    Maybe<Response<Object>> getInformationAboutUser(@Header("Authorization") String token);

    @GET("/api/v1/news")
    @Headers("Accept: application/json")
    Maybe<Response<Object>> getNews(@Header("Authorization") String token);

    @GET("/api/v1/products")
    @Headers("Accept: application/json")
    Maybe<Response<Object>> getProducts(@Header("Authorization") String token);

    @GET("/api/v1/chat")
    @Headers("Accept: application/json")
    Maybe<Response<Object>> getChats(@Header("Authorization") String token);

}
