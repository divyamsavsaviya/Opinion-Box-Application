package com.example.finalopinionbox;

import android.app.Application;

import com.firebase.client.Firebase;

public class OpinionApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
