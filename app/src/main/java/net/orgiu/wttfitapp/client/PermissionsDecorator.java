package net.orgiu.wttfitapp.client;

import android.support.annotation.NonNull;

public interface PermissionsDecorator {

    void runPermissionsCheck();

    boolean canManagePermissionResult(int requestCode);

    void managePermissionResults(@NonNull String[] permissions, @NonNull int[] grantResults);
}
