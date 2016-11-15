package net.orgiu.wttfitapp.session;


import android.support.annotation.NonNull;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.fitness.Fitness;
import com.google.android.gms.fitness.request.SessionReadRequest;
import com.google.android.gms.fitness.result.SessionReadResult;

public class SessionRequestMaker {
    private final SessionReadRequest sessionReadRequest;

    public SessionRequestMaker(@NonNull SessionReadRequest sessionReadRequest) {
        this.sessionReadRequest = sessionReadRequest;
    }

    public void makeRequest(@NonNull GoogleApiClient apiClient,
                            @NonNull ResultCallback<SessionReadResult> callback) {

        Fitness.SessionsApi.readSession(apiClient, sessionReadRequest).setResultCallback(callback);
    }
}
