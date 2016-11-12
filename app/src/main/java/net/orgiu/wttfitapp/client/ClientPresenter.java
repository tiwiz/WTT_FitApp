package net.orgiu.wttfitapp.client;


import android.support.v7.app.AppCompatActivity;

public class ClientPresenter implements ClientContract.Presenter {
    private ClientContract.View view;
    private final ApiClientManager apiClientManager;

    public ClientPresenter(AppCompatActivity target) {
        apiClientManager = new ApiClientBuilder(target,
                new ApiConnectionCallbacks(this),
                new ApiConnectionFailedCallbacks(this));
    }

    public void setView(ClientContract.View view) {
        this.view = view;
    }

    @Override
    public void connect() {
        apiClientManager.connectApiClient();
    }

    @Override
    public void onConnected() {
        view.onConnected();
    }

    @Override
    public void onConnectionFailed() {
        view.onConnectionFailed();
    }
}
