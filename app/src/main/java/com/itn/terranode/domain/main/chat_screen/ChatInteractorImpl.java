package com.itn.terranode.domain.main.chat_screen;

import androidx.paging.PagedList;
import androidx.paging.RxPagedListBuilder;

import com.itn.terranode.data.network.NetworkRepository;
import com.itn.terranode.data.network.dtos.ChatMessage;
import com.itn.terranode.data.shared_prefs.PrefsHelper;
import com.itn.terranode.presentation.view.main.chat_screen.ChatDataSourceFactory;

import javax.inject.Inject;

import io.reactivex.Maybe;
import io.reactivex.Observable;
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
    public Observable<PagedList<ChatMessage>> createChat(String userId) {
        String token = "Bearer " + prefsHelper.getToken();
        return networkRepository.createChat(token, userId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMapObservable(response -> getPagedMessages(response.body().getData()));
    }

    @Override
    public Observable<PagedList<ChatMessage>> getPagedMessages(String chatId) {
        this.chatId = chatId;
        ChatDataSourceFactory dataSourceFactory = new ChatDataSourceFactory(networkRepository, prefsHelper, chatId);
        PagedList.Config config = (new PagedList.Config.Builder())
                .setEnablePlaceholders(false)
                .setPageSize(20)
                .build();
        return new RxPagedListBuilder(dataSourceFactory, config)
                .buildObservable();
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
