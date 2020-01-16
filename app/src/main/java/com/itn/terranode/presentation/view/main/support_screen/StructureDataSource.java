package com.itn.terranode.presentation.view.main.support_screen;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import com.itn.terranode.data.network.NetworkRepository;
import com.itn.terranode.data.network.dtos.SuccessStructureResponce;
import com.itn.terranode.data.network.dtos.User;
import com.itn.terranode.data.shared_prefs.PrefsHelper;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

class StructureDataSource extends PageKeyedDataSource<Integer, User> {

    private final NetworkRepository networkRepository;
    private final PrefsHelper prefsHelper;

    StructureDataSource(NetworkRepository networkRepository, PrefsHelper prefsHelper) {
        this.networkRepository = networkRepository;
        this.prefsHelper = prefsHelper;
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Integer, User> callback) {
        String token = "Bearer " + prefsHelper.getToken();

        networkRepository
                .getPagedStructure(token, 1)
                .enqueue(
                        new Callback<SuccessStructureResponce>() {
                            @Override
                            public void onResponse(@NotNull Call<SuccessStructureResponce> call, @NotNull Response<SuccessStructureResponce> response) {
                                if (response.body() != null) {
                                    if(response.body().getData().getUsers().size() > 0) {
                                        callback.onResult(response.body().getData().getUsers(),
                                                response.body().getData().getFrom() - 1,//position
                                                response.body().getData().getTotal(),//totalCount
                                                null,
                                                response.body().getData().getLastPage() == 1 ? null : response.body().getData().getCurrentPage() + 1
                                        );
                                    } else {
                                        callback.onResult(response.body().getData().getUsers(), null,null);
                                    }
                                }
                            }

                            @Override
                            public void onFailure(@NotNull Call<SuccessStructureResponce> call, @NotNull Throwable t) {
                            }
                        }
                );
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, User> callback) {
        //not used
    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, User> callback) {
        String token = "Bearer " + prefsHelper.getToken();
        networkRepository
                .getPagedStructure(token, params.key)
                .enqueue(
                        new Callback<SuccessStructureResponce>() {
                            @Override
                            public void onResponse(@NotNull Call<SuccessStructureResponce> call, @NotNull Response<SuccessStructureResponce> response) {
                                if (response.body() != null) {
                                    callback.onResult(response.body().getData().getUsers(), params.key + 1);
                                }
                            }

                            @Override
                            public void onFailure(@NotNull Call<SuccessStructureResponce> call, @NotNull Throwable t) {
                                //  если не загрузилось - значит не загрузилось
                            }
                        }
                );
    }
}
