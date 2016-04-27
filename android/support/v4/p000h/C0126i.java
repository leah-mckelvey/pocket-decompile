package android.support.v4.p000h;

import android.os.Build.VERSION;
import android.view.LayoutInflater;

/* renamed from: android.support.v4.h.i */
public class C0126i {
    static final C0127j f421a;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            f421a = new C0130m();
        } else if (i >= 11) {
            f421a = new C0129l();
        } else {
            f421a = new C0128k();
        }
    }

    public static void m949a(LayoutInflater layoutInflater, C0058s c0058s) {
        f421a.m950a(layoutInflater, c0058s);
    }
}
