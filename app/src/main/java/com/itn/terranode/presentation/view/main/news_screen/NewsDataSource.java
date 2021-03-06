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

public class NewsDataSource extends PageKeyedDataSource<Integer, NewsItem> {

    private NetworkRepository networkRepository;
    private PrefsHelper prefsHelper;

    NewsDataSource(NetworkRepository networkRepository, PrefsHelper prefsHelper) {
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
                                    if(response.body().getData().getNewsItems().size() > 0) {
                                        callback.onResult(response.body().getData().getNewsItems(),
                                                response.body().getData().getFrom() - 1,//position
                                                response.body().getData().getTotal(),//totalCount
                                                null,
                                                response.body().getData().getLastPage() == 1 ? null : response.body().getData().getCurrentPage() + 1
                                        );
                                    } else {
                                        callback.onResult(response.body().getData().getNewsItems(), null,null);
                                    }
                                }
                            }

                            @Override
                            public void onFailure(@NotNull Call<SuccessNewsResponse> call, @NotNull Throwable t) {
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
                                    if (response.body() != null) {
                                        callback.onResult(response.body().getData().getNewsItems(), params.key + 1);
                                    }
                                }

                                @Override
                                public void onFailure(@NotNull Call<SuccessNewsResponse> call, @NotNull Throwable t) {
                                    //  если не загрузилось - значит не загрузилось
                                }
                        }
                );
    }
}
