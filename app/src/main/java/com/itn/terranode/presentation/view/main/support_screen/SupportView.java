package com.itn.terranode.presentation.view.main.support_screen;

import androidx.paging.PagedList;

import com.itn.terranode.data.network.dtos.Chat;
import com.itn.terranode.data.network.dtos.User;

import java.util.List;

import moxy.MvpView;
import moxy.viewstate.strategy.AddToEndSingleStrategy;
import moxy.viewstate.strategy.StateStrategyType;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface SupportView extends MvpView {

    void showChats(List<Chat> chatsList);

    void showStructure(PagedList<User> usersList);

    void showSearchResult(List<User> usersList);

    void showProgressBar();

    void hideProgressBar();

    void showToast(String message);

    void showChatsAndStructure();
}
