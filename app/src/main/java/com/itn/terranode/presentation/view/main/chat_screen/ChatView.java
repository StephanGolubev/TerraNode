package com.itn.terranode.presentation.view.main.chat_screen;

import com.itn.terranode.data.network.dtos.Chat;
import com.itn.terranode.data.network.dtos.ChatMessage;
import com.itn.terranode.data.network.dtos.User;

import java.util.List;

import moxy.MvpView;
import moxy.viewstate.strategy.AddToEndSingleStrategy;
import moxy.viewstate.strategy.StateStrategyType;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface ChatView extends MvpView {

    void showChat(List<ChatMessage> chatsList, String currentId);

    void showProgressBar();

    void hideProgressBar();

    void showToast(String message);
}
