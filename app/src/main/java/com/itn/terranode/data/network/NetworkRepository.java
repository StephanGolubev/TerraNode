package com.itn.terranode.data.network;

import com.itn.terranode.data.network.dtos.LoginDTO;
import com.itn.terranode.data.network.dtos.NewAccountDTO;
import com.itn.terranode.data.network.dtos.SuccessChatsResponce;
import com.itn.terranode.data.network.dtos.SuccessCreateChatResponce;
import com.itn.terranode.data.network.dtos.SuccessGetMessageFromChatResponce;
import com.itn.terranode.data.network.dtos.SuccessLogoutResponse;
import com.itn.terranode.data.network.dtos.SuccessNewsResponse;
import com.itn.terranode.data.network.dtos.SuccessOfficeResponse;
import com.itn.terranode.data.network.dtos.SuccessProductsResponse;
import com.itn.terranode.data.network.dtos.SuccessSearchResponce;
import com.itn.terranode.data.network.dtos.SuccessStructureResponce;

import io.reactivex.Maybe;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface NetworkRepository {

    @POST("/api/v1/register")
    Maybe<Response<Object>> createNewAccount(@Body NewAccountDTO gatewayAuthorizeRequest);

    @POST("/api/v1/login")
    Maybe<Response<Object>> login(@Body LoginDTO gatewayAuthorizeRequest);

    @GET("/api/v1/user")
    @Headers("Accept: application/json")
    Maybe<SuccessOfficeResponse> getInformationAboutUser(@Header("Authorization") String token);

    @POST("/api/v1/login")
    Maybe<SuccessLogoutResponse> logout(@Header("Authorization")String token);

    @GET("/api/v1/news")
    @Headers("Accept: application/json")
    Maybe<SuccessNewsResponse> getNews(@Header("Authorization") String token);

    @GET("/api/v1/products")
    @Headers("Accept: application/json")
    Maybe<SuccessProductsResponse> getProducts(@Header("Authorization") String token);

    @GET("api/v1/structure")
    @Headers("Accept: application/json")
    Maybe<SuccessStructureResponce> getStructure(@Header("Authorization") String token);

    @POST("api/v1/search/users")
    Maybe<SuccessSearchResponce> searchUsers(@Header("Authorization")String token, @Query("search_term") String searchTerm);

    @GET("/api/v1/chat")
    @Headers("Accept: application/json")
    Maybe<SuccessChatsResponce> getChatsList(@Header("Authorization") String token);

    @POST("/api/v1/chat")
    Maybe<SuccessCreateChatResponce> createChat(@Header("Authorization")String token, @Query("interlocutor_id") String userId);
//
//    @POST("/api/v1/chat/{chatId}/message")
//    Maybe<SuccessAddMessageToChatResponce> addMessageToChat(@Header("Authorization")String token, @Path ("chatId") String id, @Query("message") String messageString);

    @GET("/api/v1/chat/{chatId}/message")
    Maybe<SuccessGetMessageFromChatResponce> getMessageFromChat(@Header("Authorization")String token, @Path ("chatId") String id);
}
