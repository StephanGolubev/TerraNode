package com.itn.terranode.domain.main.chat_screen;

import com.itn.terranode.data.network.NetworkRepository;
import com.itn.terranode.data.network.dtos.SuccessChatsResponce;
import com.itn.terranode.data.network.dtos.SuccessCreateChatResponce;
import com.itn.terranode.data.network.dtos.SuccessGetMessageFromChatResponce;
import com.itn.terranode.data.shared_prefs.PrefsHelper;

import javax.inject.Inject;

import io.reactivex.Maybe;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ChatInteractorImpl implements ChatInteractor {

    private final NetworkRepository networkRepository;
    private final PrefsHelper prefsHelper;

    @Inject
    ChatInteractorImpl(NetworkRepository networkRepository, PrefsHelper prefsHelper) {
        this.networkRepository = networkRepository;
        this.prefsHelper = prefsHelper;
    }

    @Override
    public Maybe<SuccessGetMessageFromChatResponce> createChat(String userId) {
        String token = "Bearer " + prefsHelper.getToken();
        return networkRepository.createChat(token, userId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(successCreateChatResponce -> getMessages(successCreateChatResponce.getData()));
    }

    @Override
    public Maybe<SuccessGetMessageFromChatResponce> getMessages(String chatId) {
        String token = "Bearer " + prefsHelper.getToken();
        return networkRepository.getMessageFromChat(token, chatId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public String getCurrentId() {
        return prefsHelper.getId();
    }

//    @Override
//    public Maybe<SuccessAddMessageToChatResponce> sendMessage(String chatId, String message) {
//        String token = "Bearer " + prefsHelper.getToken();
//        return networkRepository.addMessageToChat(token, chatId, message)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread());
//    }
}
