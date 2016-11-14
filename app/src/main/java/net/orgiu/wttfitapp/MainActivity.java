package net.orgiu.wttfitapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.android.gms.common.api.GoogleApiClient;

import net.orgiu.wttfitapp.client.ApiClientBuilder;
import net.orgiu.wttfitapp.client.ApiClientManager;
import net.orgiu.wttfitapp.client.ApiConnectionCallbacks;
import net.orgiu.wttfitapp.client.ApiConnectionFailedCallbacks;
import net.orgiu.wttfitapp.client.ClientContract;
import net.orgiu.wttfitapp.client.ClientPresenter;
import net.orgiu.wttfitapp.client.ClientView;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ClientView clientView = (ClientView) findViewById(R.id.clientConnectView);
        clientView.setPresenter(new ClientPresenter(this));
    }

}
