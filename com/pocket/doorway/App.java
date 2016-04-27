package com.pocket.doorway;

import android.app.Application;
import android.content.Context;

public class App extends Application {
    private static App f1504a;

    public App() {
        f1504a = this;
    }

    public static Context m2304a() {
        return f1504a;
    }
}
