package android.support.v4.widget;

import android.database.ContentObserver;
import android.os.Handler;

/* renamed from: android.support.v4.widget.g */
class C0152g extends ContentObserver {
    final /* synthetic */ C0150e f490a;

    public C0152g(C0150e c0150e) {
        this.f490a = c0150e;
        super(new Handler());
    }

    public boolean deliverSelfNotifications() {
        return true;
    }

    public void onChange(boolean z) {
        this.f490a.m1079b();
    }
}
