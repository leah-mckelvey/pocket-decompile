package android.support.v7.p011a;

import android.content.Context;
import android.view.Window;
import android.view.Window.Callback;

/* renamed from: android.support.v7.a.w */
class C0196w extends C0195v {
    private boolean f666n;

    C0196w(Context context, Window window, C0172r c0172r) {
        super(context, window, c0172r);
        this.f666n = true;
    }

    Callback m1351a(Callback callback) {
        return new C0197x(this, callback);
    }
}
