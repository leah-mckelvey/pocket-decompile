package android.support.v4.p000h;

import android.view.View;
import android.view.animation.Interpolator;

/* renamed from: android.support.v4.h.ce */
class ce {
    public static void m913a(View view) {
        view.animate().cancel();
    }

    public static void m914a(View view, float f) {
        view.animate().alpha(f);
    }

    public static void m915a(View view, long j) {
        view.animate().setDuration(j);
    }

    public static void m916a(View view, ck ckVar) {
        if (ckVar != null) {
            view.animate().setListener(new cf(ckVar, view));
        } else {
            view.animate().setListener(null);
        }
    }

    public static void m917a(View view, Interpolator interpolator) {
        view.animate().setInterpolator(interpolator);
    }

    public static void m918b(View view) {
        view.animate().start();
    }

    public static void m919b(View view, float f) {
        view.animate().translationX(f);
    }

    public static void m920b(View view, long j) {
        view.animate().setStartDelay(j);
    }

    public static void m921c(View view, float f) {
        view.animate().translationY(f);
    }

    public static void m922d(View view, float f) {
        view.animate().scaleY(f);
    }
}
