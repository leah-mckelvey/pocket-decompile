package android.support.v4.p000h;

import android.view.View;

/* renamed from: android.support.v4.h.bh */
class bh {
    public static int m829a(View view) {
        return view.getMinimumHeight();
    }

    public static void m830a(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    public static void m831a(View view, Runnable runnable, long j) {
        view.postOnAnimationDelayed(runnable, j);
    }

    public static void m832b(View view) {
        view.requestFitSystemWindows();
    }

    public static boolean m833c(View view) {
        return view.getFitsSystemWindows();
    }
}
