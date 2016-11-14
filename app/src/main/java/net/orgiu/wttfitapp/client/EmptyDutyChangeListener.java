package net.orgiu.wttfitapp.client;


import com.google.android.gms.common.api.GoogleApiClient;

import net.orgiu.wttfitapp.DutyChangeListener;

import timber.log.Timber;

final class EmptyDutyChangeListener implements DutyChangeListener {
    static final DutyChangeListener INSTANCE = new EmptyDutyChangeListener();

    private EmptyDutyChangeListener() {
    }

    @Override
    public void onDutyChangeRequested(GoogleApiClient client) {
        Timber.e("onDutyChangedRequest has been called on INSTANCE listener, the Attached Activity does not implement the DutyChangeListener interface as it shall!");
    }
}
