package com.itn.terranode.domain.main.chat_screen;

import com.itn.terranode.data.network.dtos.SuccessGetMessageFromChatResponce;

import io.reactivex.Maybe;

public interface ChatInteractor {

    Maybe<SuccessGetMessageFromChatResponce> createChat(String userId);

    Maybe<SuccessGetMessageFromChatResponce> getMessages(String chatId);

    String getCurrentId();

//    Maybe<SuccessAddMessageToChatResponce> sendMessage(String chadId, String message);
}
