package net.orgiu.wttfitapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.android.gms.common.api.GoogleApiClient;

import net.orgiu.wttfitapp.client.ApiClientBuilder;
import net.orgiu.wttfitapp.client.ApiClientManager;
import net.orgiu.wttfitapp.client.ApiConnectionCallbacks;
import net.orgiu.wttfitapp.client.ApiConnectionFailedCallbacks;
import net.orgiu.wttfitapp.client.ClientContract;
import net.orgiu.wttfitapp.client.ClientPresenter;
import net.orgiu.wttfitapp.client.ClientView;
import net.orgiu.wttfitapp.session.SessionPresenter;

public class MainActivity extends AppCompatActivity implements DutyChangeListener{
    private ClientView clientView;
    private RecyclerView sessionList;

    private SessionPresenter sessionPresenter;
    private PermissionManager permissionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        permissionManager = new PermissionManager(this);
        buildUI();
    }



    private void buildUI() {
        clientView = (ClientView) findViewById(R.id.clientConnectView);
        clientView.setPresenter(new ClientPresenter(this));

        sessionList = (RecyclerView) findViewById(R.id.sessionList);
        sessionList.setLayoutManager(new LinearLayoutManager(this));
        sessionPresenter = new SessionPresenter();
        sessionPresenter.addView(sessionList);
    }

    @Override
    public void onDutyChangeRequested(GoogleApiClient client) {
        clientView.setVisibility(View.GONE);
        sessionList.setVisibility(View.VISIBLE);
        sessionPresenter.addGoogleClient(client);
        initPermissions();
    }

    private void initPermissions() {
        if (!permissionManager.hasPermissions()) {
            permissionManager.requestPermissions();
        } else {
            sessionPresenter.loadSessions();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (permissionManager.canManageRequest(requestCode) && permissionManager.hasPermissionsBeenGranted(permissions, grantResults)) {
            sessionPresenter.loadSessions();
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }
}
