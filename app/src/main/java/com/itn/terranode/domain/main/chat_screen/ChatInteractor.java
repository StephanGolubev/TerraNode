package com.itn.terranode.domain.main.chat_screen;

import androidx.paging.PagedList;

import com.itn.terranode.data.network.dtos.ChatMessage;

import io.reactivex.Maybe;
import io.reactivex.Observable;
import retrofit2.Response;

public interface ChatInteractor {

    Observable<PagedList<ChatMessage>>  createChat(String userId);

    Observable<PagedList<ChatMessage>> getPagedMessages(String chatId);

    String getCurrentId();

    Maybe<Response<Void>>  sendMessage( String message);
}
