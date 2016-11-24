package com.neel.firebasenotifications;

import android.app.Application;

public class MyApplication extends Application {
 
    @Override
    public void onCreate() {
        super.onCreate();
        //Initializing firebase
        //Firebase.setAndroidContext(getApplicationContext());
    }
}