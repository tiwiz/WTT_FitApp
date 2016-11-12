package net.orgiu.wttfitapp.client;


import android.support.annotation.NonNull;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

public class ApiConnectionFailedCallbacks implements GoogleApiClient.OnConnectionFailedListener{
    private final ClientContract.Presenter presenter;

    ApiConnectionFailedCallbacks(ClientContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        presenter.onConnectionFailed();
    }
}
