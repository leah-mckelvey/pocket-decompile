package com.pocket.doorway.input;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Messenger;

public class TractorBeamTargetingService extends Service {
    private static C0330c f1556a;
    private final C0328a f1557b;
    private final Messenger f1558c;

    public TractorBeamTargetingService() {
        this.f1557b = new C0328a(60);
        this.f1558c = new Messenger(new C0329b(this));
    }

    public static void m2368a(C0330c c0330c) {
        f1556a = c0330c;
    }

    public IBinder onBind(Intent intent) {
        return this.f1558c.getBinder();
    }
}
