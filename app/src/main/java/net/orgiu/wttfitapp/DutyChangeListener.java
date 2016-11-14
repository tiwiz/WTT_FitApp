package net.orgiu.wttfitapp;

import com.google.android.gms.common.api.GoogleApiClient;

public interface DutyChangeListener {

    void onDutyChangeRequested(GoogleApiClient client);
}
