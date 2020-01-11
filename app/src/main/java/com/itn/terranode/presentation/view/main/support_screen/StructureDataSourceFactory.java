package com.itn.terranode.presentation.view.main.support_screen;

import androidx.annotation.NonNull;
import androidx.paging.DataSource;

import com.itn.terranode.data.network.NetworkRepository;
import com.itn.terranode.data.network.dtos.User;
import com.itn.terranode.data.shared_prefs.PrefsHelper;

public class StructureDataSourceFactory extends DataSource.Factory<Integer, User> {

    private final NetworkRepository networkRepository;
    private final PrefsHelper prefsHelper;

    public StructureDataSourceFactory(NetworkRepository networkRepository, PrefsHelper prefsHelper) {
        this.networkRepository = networkRepository;
        this.prefsHelper = prefsHelper;
    }

    @NonNull
    @Override
    public DataSource<Integer, User> create() {
        return new StructureDataSource(networkRepository, prefsHelper);
    }
}
