package net.orgiu.wttfitapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import net.orgiu.wttfitapp.client.ApiClientBuilder;
import net.orgiu.wttfitapp.client.ApiClientManager;
import net.orgiu.wttfitapp.client.ApiConnectionCallbacks;
import net.orgiu.wttfitapp.client.ApiConnectionFailedCallbacks;
import net.orgiu.wttfitapp.client.ClientContract;
import net.orgiu.wttfitapp.client.ClientPresenter;

public class MainActivity extends AppCompatActivity implements ClientContract.View{
    private ClientContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new ClientPresenter(this);
    }

    public void onConnectButtonClicked(View v) {
        presenter.connect();
    }

    @Override
    public void onConnected() {

    }

    @Override
    public void onConnectionFailed() {

    }
}
