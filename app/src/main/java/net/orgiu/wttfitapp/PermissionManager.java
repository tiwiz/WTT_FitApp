package net.orgiu.wttfitapp;


import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

class PermissionManager {
    private final AppCompatActivity activity;
    private final String LOCATION_PERMISSION = Manifest.permission.ACCESS_FINE_LOCATION;
    private final int PERMISSION_REQUEST = 1337;

    PermissionManager(AppCompatActivity activity) {
        this.activity = activity;
    }

    boolean hasPermissions() {
        return (ContextCompat.checkSelfPermission(activity, LOCATION_PERMISSION)) == PackageManager.PERMISSION_GRANTED;
    }

    void requestPermissions() {
        ActivityCompat.requestPermissions(activity, new String[] {LOCATION_PERMISSION}, PERMISSION_REQUEST);
    }

    boolean canManageRequest(int requestCode) {
        return requestCode == PERMISSION_REQUEST;
    }

    boolean hasPermissionsBeenGranted(@NonNull String[] permissions, @NonNull int[] grantResults) {
        for (int result : grantResults) {
            if (result != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }

        return true;
    }
}
