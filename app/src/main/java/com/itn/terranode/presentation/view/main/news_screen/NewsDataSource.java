package com.itn.terranode.presentation.view.main.news_screen;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import com.itn.terranode.data.network.NetworkRepository;
import com.itn.terranode.data.network.dtos.NewsItem;
import com.itn.terranode.data.network.dtos.SuccessNewsResponse;
import com.itn.terranode.data.shared_prefs.PrefsHelper;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsDataSource extends PageKeyedDataSource<Long, NewsItem> {

    private NetworkRepository networkRepository;
    private PrefsHelper prefsHelper;

    public NewsDataSource(NetworkRepository networkRepository, PrefsHelper prefsHelper) {
        this.networkRepository = networkRepository;
        this.prefsHelper = prefsHelper;
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Long> params, @NonNull LoadInitialCallback<Long, NewsItem> callback) {
        String token = "Bearer " + prefsHelper.getToken();
        networkRepository.getPagedNews(token, 1).enqueue(new Callback<SuccessNewsResponse>() {
            @Override
            public void onResponse(@NotNull Call<SuccessNewsResponse> call, @NotNull Response<SuccessNewsResponse> response) {
                callback.onResult(response.body().getData().getNewsItems(),
                        response.body().getData().getCurrentPage(),//position
                        response.body().getData().getTotal(),//totalCount
                        response.body().getData().getCurrentPage() - 1L,
                        response.body().getData().getCurrentPage() + 1L
                );
            }

            @Override
            public void onFailure(@NotNull Call<SuccessNewsResponse> call, @NotNull Throwable t) {

            }
        });
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Long> params, @NonNull LoadCallback<Long, NewsItem> callback) {

    }

    @Override
    public void loadAfter(@NonNull LoadParams<Long> params, @NonNull LoadCallback<Long, NewsItem> callback) {
        String token = "Bearer " + prefsHelper.getToken();
        networkRepository.getPagedNews(token, 1).enqueue(new Callback<SuccessNewsResponse>() {
            @Override
            public void onResponse(@NotNull Call<SuccessNewsResponse> call, @NotNull Response<SuccessNewsResponse> response) {
                callback.onResult(response.body().getData().getNewsItems(), params.key + 1);
            }

            @Override
            public void onFailure(Call<SuccessNewsResponse> call, Throwable t) {

            }
        });
    }
}
