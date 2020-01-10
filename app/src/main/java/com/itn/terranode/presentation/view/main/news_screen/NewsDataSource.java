package com.itn.terranode.presentation.view.main.news_screen;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import com.itn.terranode.data.network.NetworkRepository;
import com.itn.terranode.data.network.dtos.NewsItem;
import com.itn.terranode.data.network.dtos.SuccessNewsResponse;
import com.itn.terranode.data.shared_prefs.PrefsHelper;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsDataSource extends PageKeyedDataSource<Integer, NewsItem> {

    private NetworkRepository networkRepository;
    private PrefsHelper prefsHelper;

    public NewsDataSource(NetworkRepository networkRepository, PrefsHelper prefsHelper) {
        this.networkRepository = networkRepository;
        this.prefsHelper = prefsHelper;
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Integer, NewsItem> callback) {
        String token = "Bearer " + prefsHelper.getToken();

        networkRepository
                .getPagedNews(token, 1)
                .enqueue(
                        new Callback<SuccessNewsResponse>() {
                            @Override
                            public void onResponse(@NotNull Call<SuccessNewsResponse> call, @NotNull Response<SuccessNewsResponse> response) {
                                if (response.body() != null) {
                                    callback.onResult(response.body().getData().getNewsItems(),
                                            response.body().getData().getCurrentPage(),//position
                                            response.body().getData().getTotal(),//totalCount
                                            response.body().getData().getCurrentPage() - 1,
                                            response.body().getData().getCurrentPage() + 1
                                    );
                                }
                            }

                            @Override
                            public void onFailure(@NotNull Call<SuccessNewsResponse> call, @NotNull Throwable t) {
                                callback.onError(t);
                            }
                        }
                );
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, NewsItem> callback) {
      //not used
    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, NewsItem> callback) {
        String token = "Bearer " + prefsHelper.getToken();
        networkRepository
                .getPagedNews(token, params.key)
                .enqueue(
                        new Callback<SuccessNewsResponse>() {
                                @Override
                                public void onResponse(@NotNull Call<SuccessNewsResponse> call, @NotNull Response<SuccessNewsResponse> response) {
                                    callback.onResult(response.body().getData().getNewsItems(), params.key + 1);
                                }

                                @Override
                                public void onFailure(Call<SuccessNewsResponse> call, Throwable t) {
                                    callback.onError(t);
                                }
                        }
                );
    }
}