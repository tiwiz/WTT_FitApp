package net.orgiu.wttfitapp.client;

import com.google.android.gms.common.api.GoogleApiClient;

public interface ApiClientManager {
    void connectApiClient();
    GoogleApiClient getApiClient();
}
