package net.orgiu.wttfitapp.client;


import android.os.Bundle;
import android.support.annotation.Nullable;

import com.google.android.gms.common.api.GoogleApiClient;

import timber.log.Timber;

public class ApiConnectionCallbacks implements GoogleApiClient.ConnectionCallbacks{
    private final ClientContract.Presenter presenter;

    ApiConnectionCallbacks(ClientContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        presenter.onConnected();
    }

    @Override
    public void onConnectionSuspended(int i) {
        Timber.d("Connection suspended");
    }
}
