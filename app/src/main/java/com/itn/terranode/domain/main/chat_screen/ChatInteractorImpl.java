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
import retrofit2.Response;

public class ChatInteractorImpl implements ChatInteractor {

    private final NetworkRepository networkRepository;
    private final PrefsHelper prefsHelper;
    private String chatId = "";

    @Inject
    ChatInteractorImpl(NetworkRepository networkRepository, PrefsHelper prefsHelper) {
        this.networkRepository = networkRepository;
        this.prefsHelper = prefsHelper;
    }

    @Override
    public Maybe<Response<SuccessGetMessageFromChatResponce>>  createChat(String userId) {
        String token = "Bearer " + prefsHelper.getToken();
        return networkRepository.createChat(token, userId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(successCreateChatResponce -> getMessages(successCreateChatResponce.body().getData()));
    }

    @Override
    public Maybe<Response<SuccessGetMessageFromChatResponce>>  getMessages(String chatId) {
        this.chatId = chatId;
        String token = "Bearer " + prefsHelper.getToken();
        return networkRepository.getMessageFromChat(token, chatId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public String getCurrentId() {
        return prefsHelper.getId();
    }

    @Override
    public Maybe<Response<Void>> sendMessage(String message) {
        String token = "Bearer " + prefsHelper.getToken();
        return networkRepository.addMessageToChat(token, chatId, message)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
