package net.orgiu.wttfitapp.client;


import com.google.android.gms.common.api.GoogleApiClient;

public interface ClientContract {

    interface Presenter {

        void setView(View view);
        void connect();
        void onConnected();
        void onConnectionFailed();
    }

    interface View {
        void setPresenter(Presenter presenter);
        void onConnected(GoogleApiClient client);
        void onConnectionFailed();
    }
}
