package net.orgiu.wttfitapp.client;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.fitness.Fitness;

public class ApiClientBuilder implements ApiClientManager {
    private final AppCompatActivity activity;
    private final GoogleApiClient.ConnectionCallbacks connectionCallbacks;
    private final GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener;
    private GoogleApiClient apiClient = null;

    ApiClientBuilder(@NonNull AppCompatActivity activity,
                     GoogleApiClient.ConnectionCallbacks connectionCallbacks,
                     GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {

        this.activity = activity;
        this.connectionCallbacks = connectionCallbacks;
        this.onConnectionFailedListener = onConnectionFailedListener;
    }

    @Override
    public void connectApiClient() {
        if (apiClient == null) {
            apiClient = new GoogleApiClient.Builder(activity).addApi(Fitness.SESSIONS_API)
                    .addScope(new Scope(Scopes.FITNESS_ACTIVITY_READ))
                    .addConnectionCallbacks(connectionCallbacks)
                    .enableAutoManage(activity, 0, onConnectionFailedListener)
                    .build();
        }

        apiClient.connect();
    }

    @Override
    public GoogleApiClient getApiClient() {
        return apiClient;
    }
}
