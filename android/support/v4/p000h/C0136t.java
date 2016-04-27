package android.support.v4.p000h;

import android.os.Build.VERSION;
import android.view.ViewGroup.MarginLayoutParams;

/* renamed from: android.support.v4.h.t */
public class C0136t {
    static final C0137u f425a;

    static {
        if (VERSION.SDK_INT >= 17) {
            f425a = new C0139w();
        } else {
            f425a = new C0138v();
        }
    }

    public static int m958a(MarginLayoutParams marginLayoutParams) {
        return f425a.m960a(marginLayoutParams);
    }

    public static int m959b(MarginLayoutParams marginLayoutParams) {
        return f425a.m961b(marginLayoutParams);
    }
}
