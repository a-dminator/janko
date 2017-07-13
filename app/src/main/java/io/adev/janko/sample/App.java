package io.adev.janko.sample;

import android.app.Application;

import io.adev.janko.Janko;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Janko.init(this);
    }

}
