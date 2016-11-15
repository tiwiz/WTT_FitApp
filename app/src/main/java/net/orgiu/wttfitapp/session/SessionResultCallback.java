package net.orgiu.wttfitapp.session;

import android.support.annotation.NonNull;

import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.fitness.result.SessionReadResult;


public class SessionResultCallback implements ResultCallback<SessionReadResult> {
    private final SessionAdapter adapter;

    public SessionResultCallback(SessionAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public void onResult(@NonNull SessionReadResult sessionReadResult) {
        adapter.setResults(sessionReadResult);
    }
}
