package android.support.v4.p000h;

import android.animation.ValueAnimator;
import android.graphics.Paint;
import android.view.View;

/* renamed from: android.support.v4.h.bg */
class bg {
    public static int m816a(int i, int i2) {
        return View.combineMeasuredStates(i, i2);
    }

    public static int m817a(int i, int i2, int i3) {
        return View.resolveSizeAndState(i, i2, i3);
    }

    public static int m818a(View view) {
        return view.getMeasuredState();
    }

    static long m819a() {
        return ValueAnimator.getFrameDelay();
    }

    public static void m820a(View view, float f) {
        view.setTranslationX(f);
    }

    public static void m821a(View view, int i, Paint paint) {
        view.setLayerType(i, paint);
    }

    public static void m822a(View view, boolean z) {
        view.setSaveFromParentEnabled(z);
    }

    public static float m823b(View view) {
        return view.getTranslationY();
    }

    public static void m824b(View view, float f) {
        view.setTranslationY(f);
    }

    public static void m825b(View view, boolean z) {
        view.setActivated(z);
    }

    public static void m826c(View view) {
        view.jumpDrawablesToCurrentState();
    }

    public static void m827c(View view, float f) {
        view.setAlpha(f);
    }

    public static void m828d(View view, float f) {
        view.setScaleY(f);
    }
}
