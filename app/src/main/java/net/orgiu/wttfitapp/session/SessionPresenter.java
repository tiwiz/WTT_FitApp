package net.orgiu.wttfitapp.session;


import android.support.v7.widget.RecyclerView;

import com.google.android.gms.common.api.GoogleApiClient;

public class SessionPresenter {
    private SessionRequestMaker maker;
    private SessionAdapter adapter;
    private GoogleApiClient client;

    public SessionPresenter() {
        SessionBuilder sessionBuilder = new SessionBuilder(DatesBuilder.getInstance());
        maker = new SessionRequestMaker(sessionBuilder.getReadRequest());
        adapter = new SessionAdapter();
    }

    public void addView(RecyclerView recyclerView) {
        recyclerView.setAdapter(adapter);
    }

    public void addGoogleClient(GoogleApiClient client) {
        this.client = client;
    }

    public void loadSessions() {
        maker.makeRequest(client, new SessionResultCallback(adapter));
    }
}
