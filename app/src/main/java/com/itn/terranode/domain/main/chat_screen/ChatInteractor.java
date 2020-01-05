package com.itn.terranode.domain.main.chat_screen;

import com.itn.terranode.data.network.dtos.SuccessGetMessageFromChatResponce;

import io.reactivex.Maybe;
import io.reactivex.disposables.Disposable;
import retrofit2.Response;

public interface ChatInteractor {

    Maybe<Response<SuccessGetMessageFromChatResponce>>  createChat(String userId);

    Maybe<Response<SuccessGetMessageFromChatResponce>>  getMessages(String chatId);

    String getCurrentId();

    Maybe<Response<Void>>  sendMessage( String message);
}
