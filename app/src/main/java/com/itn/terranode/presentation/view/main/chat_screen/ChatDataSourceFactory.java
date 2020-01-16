package com.itn.terranode.presentation.view.main.chat_screen;

import androidx.annotation.NonNull;
import androidx.paging.DataSource;

import com.itn.terranode.data.network.NetworkRepository;
import com.itn.terranode.data.network.dtos.ChatMessage;
import com.itn.terranode.data.shared_prefs.PrefsHelper;

public class ChatDataSourceFactory extends DataSource.Factory<Integer, ChatMessage> {

    private final NetworkRepository networkRepository;
    private final PrefsHelper prefsHelper;
    private final String id;

    public ChatDataSourceFactory(NetworkRepository networkRepository, PrefsHelper prefsHelper, String id) {
        this.networkRepository = networkRepository;
        this.prefsHelper = prefsHelper;
        this.id = id;
    }

    @NonNull
    @Override
    public DataSource<Integer, ChatMessage> create() {
        return new ChatDataSource(networkRepository, prefsHelper, id);
    }
}