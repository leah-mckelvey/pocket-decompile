package android.support.v4.p000h;

import android.graphics.Rect;
import android.os.Build.VERSION;

/* renamed from: android.support.v4.h.d */
public class C0121d {
    static final C0122e f420a;

    static {
        if (VERSION.SDK_INT >= 17) {
            f420a = new C0124g();
        } else {
            f420a = new C0123f();
        }
    }

    public static int m939a(int i, int i2) {
        return f420a.m941a(i, i2);
    }

    public static void m940a(int i, int i2, int i3, Rect rect, Rect rect2, int i4) {
        f420a.m942a(i, i2, i3, rect, rect2, i4);
    }
}
