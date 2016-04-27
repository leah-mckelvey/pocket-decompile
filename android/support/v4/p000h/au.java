package android.support.v4.p000h;

import android.graphics.Paint;
import android.os.Build.VERSION;
import android.view.View;

/* renamed from: android.support.v4.h.au */
public class au {
    static final be f395a;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            f395a = new bd();
        } else if (i >= 19) {
            f395a = new bc();
        } else if (i >= 17) {
            f395a = new bb();
        } else if (i >= 16) {
            f395a = new ba();
        } else if (i >= 14) {
            f395a = new az();
        } else if (i >= 11) {
            f395a = new ay();
        } else if (i >= 9) {
            f395a = new ax();
        } else if (i >= 7) {
            f395a = new aw();
        } else {
            f395a = new av();
        }
    }

    public static int m681a(int i, int i2) {
        return f395a.m712a(i, i2);
    }

    public static int m682a(int i, int i2, int i3) {
        return f395a.m713a(i, i2, i3);
    }

    public static int m683a(View view) {
        return f395a.m714a(view);
    }

    public static cn m684a(View view, cn cnVar) {
        return f395a.m715a(view, cnVar);
    }

    public static void m685a(View view, float f) {
        f395a.m716a(view, f);
    }

    public static void m686a(View view, int i, int i2, int i3, int i4) {
        f395a.m717a(view, i, i2, i3, i4);
    }

    public static void m687a(View view, int i, Paint paint) {
        f395a.m718a(view, i, paint);
    }

    public static void m688a(View view, ao aoVar) {
        f395a.m719a(view, aoVar);
    }

    public static void m689a(View view, Runnable runnable) {
        f395a.m720a(view, runnable);
    }

    public static void m690a(View view, Runnable runnable, long j) {
        f395a.m721a(view, runnable, j);
    }

    public static void m691a(View view, boolean z) {
        f395a.m722a(view, z);
    }

    public static int m692b(View view) {
        return f395a.m723b(view);
    }

    public static cn m693b(View view, cn cnVar) {
        return f395a.m724b(view, cnVar);
    }

    public static void m694b(View view, float f) {
        f395a.m725b(view, f);
    }

    public static void m695b(View view, boolean z) {
        f395a.m726b(view, z);
    }

    public static int m696c(View view) {
        return f395a.m727c(view);
    }

    public static void m697c(View view, float f) {
        f395a.m728c(view, f);
    }

    public static int m698d(View view) {
        return f395a.m729d(view);
    }

    public static void m699d(View view, float f) {
        f395a.m730d(view, f);
    }

    public static float m700e(View view) {
        return f395a.m731e(view);
    }

    public static void m701e(View view, float f) {
        f395a.m732e(view, f);
    }

    public static int m702f(View view) {
        return f395a.m733f(view);
    }

    public static bt m703g(View view) {
        return f395a.m734g(view);
    }

    public static int m704h(View view) {
        return f395a.m735h(view);
    }

    public static void m705i(View view) {
        f395a.m736i(view);
    }

    public static boolean m706j(View view) {
        return f395a.m737l(view);
    }

    public static void m707k(View view) {
        f395a.m738m(view);
    }

    public static boolean m708l(View view) {
        return f395a.m739n(view);
    }

    public static boolean m709m(View view) {
        return f395a.m740o(view);
    }

    public static float m710n(View view) {
        return f395a.m741p(view);
    }

    public static boolean m711o(View view) {
        return f395a.m742q(view);
    }
}
