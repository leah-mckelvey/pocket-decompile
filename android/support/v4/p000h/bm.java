package android.support.v4.p000h;

import android.os.Build.VERSION;
import android.view.ViewConfiguration;

/* renamed from: android.support.v4.h.bm */
public class bm {
    static final br f401a;

    static {
        if (VERSION.SDK_INT >= 14) {
            f401a = new bq();
        } else if (VERSION.SDK_INT >= 11) {
            f401a = new bp();
        } else if (VERSION.SDK_INT >= 8) {
            f401a = new bo();
        } else {
            f401a = new bn();
        }
    }

    public static boolean m850a(ViewConfiguration viewConfiguration) {
        return f401a.m851a(viewConfiguration);
    }
}
