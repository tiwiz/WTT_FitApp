package net.orgiu.wttfitapp;

import android.app.Application;

import timber.log.Timber;


public class FitApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());
    }
}
