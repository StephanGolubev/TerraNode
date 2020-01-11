package com.itn.terranode.presentation.view.main.chat_screen;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import com.itn.terranode.data.network.NetworkRepository;
import com.itn.terranode.data.network.dtos.ChatMessage;
import com.itn.terranode.data.network.dtos.SuccessGetMessageFromChatResponse;
import com.itn.terranode.data.shared_prefs.PrefsHelper;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

class ChatDataSource extends PageKeyedDataSource<Integer, ChatMessage> {

    private NetworkRepository networkRepository;
    private PrefsHelper prefsHelper;
    private String chatId;

    public ChatDataSource(NetworkRepository networkRepository, PrefsHelper prefsHelper, String chatId) {
        this.networkRepository = networkRepository;
        this.prefsHelper = prefsHelper;
        this.chatId = chatId;
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Integer, ChatMessage> callback) {
        String token = "Bearer " + prefsHelper.getToken();

        networkRepository
                .getPagedMessageFromChat(token, chatId, 1)
                .enqueue(
                        new Callback<SuccessGetMessageFromChatResponse>() {
                            @Override
                            public void onResponse(@NotNull Call<SuccessGetMessageFromChatResponse> call, @NotNull Response<SuccessGetMessageFromChatResponse> response) {
                                if (response.body() != null) {
                                    callback.onResult(response.body().getData().getChatMessages(),
                                            null,
                                            response.body().getData().getCurrentPage() == 1 ? null: response.body().getData().getCurrentPage() + 1
                                    );
                                }
                            }

                            @Override
                            public void onFailure(@NotNull Call<SuccessGetMessageFromChatResponse> call, @NotNull Throwable t) {
//                                callback.onError(t);
                            }
                        }
                );
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, ChatMessage> callback) {
        //not used
    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, ChatMessage> callback) {
        String token = "Bearer " + prefsHelper.getToken();
        networkRepository
                .getPagedMessageFromChat(token, chatId, params.key)
                .enqueue(
                        new Callback<SuccessGetMessageFromChatResponse>() {
                            @Override
                            public void onResponse(@NotNull Call<SuccessGetMessageFromChatResponse> call, @NotNull Response<SuccessGetMessageFromChatResponse> response) {
                                if (response.body() != null) {
                                    callback.onResult(response.body().getData().getChatMessages(), params.key + 1);
                                }
                            }

                            @Override
                            public void onFailure(@NotNull Call<SuccessGetMessageFromChatResponse> call, @NotNull Throwable t) {
//                                callback.onError(t);
                            }
                        }
                );
    }
}
