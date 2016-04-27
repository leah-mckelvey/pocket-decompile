package android.support.v4.widget;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.OverScroller;

/* renamed from: android.support.v4.widget.w */
class C0167w {
    public static int m1128a(Object obj) {
        return ((OverScroller) obj).getCurrX();
    }

    public static Object m1129a(Context context, Interpolator interpolator) {
        return interpolator != null ? new OverScroller(context, interpolator) : new OverScroller(context);
    }

    public static void m1130a(Object obj, int i, int i2, int i3, int i4, int i5) {
        ((OverScroller) obj).startScroll(i, i2, i3, i4, i5);
    }

    public static void m1131a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        ((OverScroller) obj).fling(i, i2, i3, i4, i5, i6, i7, i8);
    }

    public static int m1132b(Object obj) {
        return ((OverScroller) obj).getCurrY();
    }

    public static boolean m1133c(Object obj) {
        return ((OverScroller) obj).computeScrollOffset();
    }

    public static void m1134d(Object obj) {
        ((OverScroller) obj).abortAnimation();
    }

    public static int m1135e(Object obj) {
        return ((OverScroller) obj).getFinalX();
    }

    public static int m1136f(Object obj) {
        return ((OverScroller) obj).getFinalY();
    }
}
