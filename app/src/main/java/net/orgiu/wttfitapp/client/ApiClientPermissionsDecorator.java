package net.orgiu.wttfitapp.client;


import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.common.api.GoogleApiClient;

public class ApiClientPermissionsDecorator implements ApiClientManager, PermissionsDecorator {
    private final AppCompatActivity activity;
    private final ApiClientManager decorated;

    private final int REQUEST_CODE = 1337;
    private final String[] PERMISSIONS = new String[]{Manifest.permission.BODY_SENSORS};


    public ApiClientPermissionsDecorator(AppCompatActivity activity,
                                         ApiClientManager decorated) {
        this.activity = activity;
        this.decorated = decorated;
    }

    @Override
    public void runPermissionsCheck() {
        if (!arePermissionsGranted()) {
            requestPermissions();
        }
    }

    @Override
    public boolean canManagePermissionResult(int requestCode) {
        return requestCode == REQUEST_CODE;
    }

    @Override
    public void managePermissionResults(@NonNull String[] permissions, @NonNull int[] grantResults) {
        for (int grantResult : grantResults) {
            if (grantResult != PackageManager.PERMISSION_GRANTED) {
                return;
            }
        }

        buildApiClient();
    }

    private boolean arePermissionsGranted() {
        for (String permission : PERMISSIONS) {
            if (isPermissionGranted(permission)) {
                return false;
            }
        }
        return true;
    }

    private boolean isPermissionGranted(String permission) {
        return ActivityCompat.checkSelfPermission(activity, permission) != PackageManager.PERMISSION_GRANTED;
    }

    private void requestPermissions() {
        ActivityCompat.requestPermissions(activity, PERMISSIONS, REQUEST_CODE);
    }

    @Override
    public void buildApiClient() {
        if (arePermissionsGranted()) {
            decorated.buildApiClient();
        }
    }

    @Override
    public GoogleApiClient getApiClient() {
        return decorated.getApiClient();
    }
}
